package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> getList(Criteria cri, Long bno); 
	public int modify(ReplyVO reply);
	public int remove(Long bno);
	public ReplyVO get(Long bno);
	public int register(ReplyVO vo);
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}









