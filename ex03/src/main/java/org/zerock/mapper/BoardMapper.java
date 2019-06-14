package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	public int getTotalCount(Criteria cri);
	public List<BoardVO> getListWithPaging(Criteria cri);
	public int update(BoardVO board);
	public int delete(Long bno);
	public BoardVO read(Long bno);
	public Integer insertSelectKey(BoardVO board);
	public void insert(BoardVO board);
//	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList();
}












