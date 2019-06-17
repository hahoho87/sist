package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("댓글 목록 가져오기 - 게시물 번호 : " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public int modify(ReplyVO reply) {
		log.info("댓글 수정 : " + reply);
		return mapper.update(reply);
	}

	@Override
	public int remove(Long bno) {
		log.info("댓글 삭제 - 댓글 번호 : " + bno);
		return mapper.delete(bno);
	}

	@Override
	public ReplyVO get(Long bno) {
		log.info("댓글 조회 - 댓글 번호 : " + bno);
		return mapper.read(bno);
	}

	@Override
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}
	
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		//특정 게시물의 전체 댓글 개수와 댓글 목록 반환
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}
}
