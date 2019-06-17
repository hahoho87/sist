package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> getListWithPaging(
					@Param("cri") Criteria cri,
					@Param("bno") Long bno); 
	public int update(ReplyVO reply);
	public int delete(Long bno);
	public ReplyVO read(Long bno);
	public int insert(ReplyVO vo);
	public int getCountByBno(Long bno);
}
