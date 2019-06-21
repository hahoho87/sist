package edu.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import edu.practice.service.BoardServiceImpl;

import edu.practice.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import edu.practice.domain.BoardVO;
import edu.practice.domain.Criteria;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	// spring 4.3 이상에서 자동 처리
	// AllArgsConstructor 어노테이션으로 BoardMapper를 주입받는 생성자 생성
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register...." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get...." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..." + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);
		return mapper.delete(bno) == 1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("get list...");
//		return mapper.getList();
//	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with Criteria : " + cri);
		return mapper.getListWithPaging(cri);
	}

}
