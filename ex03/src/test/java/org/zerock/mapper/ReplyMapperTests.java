package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private ReplyMapper mapper;
	
	//기존 게시물 5개 bno를 배열로 저장
	private Long[] bnoArr = { 51L, 52L, 53L, 54L, 55L };
	
	@Test 
	public void testList2() {
		Criteria cri = new Criteria(1, 5);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 116L);
		
		replies.forEach(reply -> log.info(reply));
	}
//	
//	@Test
//	public void testList() {
//		//222번 게시물이 댓글 목록
//		Criteria cri = new Criteria();
//		List<ReplyVO> replies 
//			= mapper.getListWithPaging(cri, bnoArr[0]);
//		replies.forEach(reply -> log.info(reply));
//	}
	
//	@Test
//	public void testUpdate() {
//		//10번 댓글 수정
//		Long targetRno = 10L;
//		ReplyVO vo = mapper.read(targetRno);
//		vo.setReply("댓글 수정 테스트 ");  //변경 댓글
//		int count = mapper.update(vo);
//		log.info("UPDATE COUNT : " + count);
//	}
	
//	@Test
//	public void testDelete() {
//		//4번 댓글 삭제
//		Long targetRno = 4L;
//		mapper.delete(targetRno);
//	}
	
//	@Test
//	public void testRead() {
//		//5번 댓글 조회
//		Long targetRno = 5L;
//		ReplyVO vo = mapper.read(targetRno);
//		log.info(vo);
//	}
	
//	@Test
//	public void testCreate() {
//		//기존 게시물 5개에 댓글 등록 테스트
//		IntStream.rangeClosed(1, 10)
//				 .forEach(i -> {
//					 ReplyVO vo = new ReplyVO();
//					 vo.setBno(bnoArr[i % 5]);	//게시물 번호
//					 vo.setReply("댓글 테스트 " + i);  //댓글
//					 vo.setReplyer("replyer " + i);//작성자
//					 mapper.insert(vo);
//				 });
//	}
	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
}












