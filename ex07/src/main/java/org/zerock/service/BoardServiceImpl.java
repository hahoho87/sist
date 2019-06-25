package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");	//get total count를 로그로 기록
		return mapper.getTotalCount(cri);
	}
	
	@Override
//	public List<BoardVO> getList() {
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList with criteria : " + cri);
//		return mapper.getList();
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public BoardVO get(Long bno) {
		log.info("get...... : " + bno);
		return mapper.read(bno);
	}
	
	@Transactional
	@Override
	public void register(BoardVO board) {
		log.info("register..... : " + board);
		mapper.insertSelectKey(board);
		
		//첨부파일이 없는 경우
		if(board.getAttachList() == null || board.getAttachList().size() <= 0 ) {
			return;
		}
		//첨부파일이 있는 경우 
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..... : " + board);
		
		attachMapper.deleteAll(board.getBno());	//첨부 파일 모두 삭제
		boolean modifyResult = mapper.update(board) == 1;	//수정 처리
		
		if(modifyResult 							//수정 성공
				&& board.getAttachList() != null	//첨부파일 목록이 있으면
				&& board.getAttachList().size() > 0) {
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);	//첨부파일 등록
			});
		}
		return modifyResult;
	}

	//테이블 두 개에서 동시에 삭제되기 때문에 Transactional
	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("remove..... : " + bno);
		attachMapper.deleteAll(bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno" + bno);
		return attachMapper.findByBno(bno);
	}
}
