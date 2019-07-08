package edu.practice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.practice.domain.Criteria;
import edu.practice.domain.ReplyVO;
import edu.practice.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
	
	//댓글 등록
	@PostMapping(value="/new",					//POST 방식
				 consumes = "application/json",	//JSON 데이터
				 produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("ReplyVO : " + vo);
		int insertCount = service.register(vo);	//댓글 등록
		
		if(insertCount == 1) {	//insertCount가 1이면 등록 성공
												   //HttpStatus 200 반환
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {	//실패하면						   //500반환
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//특정 게시물의 댓글 목록
	@GetMapping(value = "/pages/{bno}/{page}",
			    produces = { MediaType.APPLICATION_XML_VALUE,
			    		     MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReplyVO>> getList(
							@PathVariable("page") int page,
							@PathVariable("bno") Long bno){
		log.info("getList...............");
		Criteria cri = new Criteria(page, 10);
		log.info("cri : " + cri);
		
		return  new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
	}
	
	//특정 댓글 조회
	@GetMapping(value = "/{rno}",
		    produces = { MediaType.APPLICATION_XML_VALUE,
		    		     MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(
							@PathVariable("rno") Long rno){
		log.info("get......... : " + rno);
		return  new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	//특정 댓글 삭제
	@DeleteMapping(value = "/{rno}",
		    	   produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove : " + rno);
		int delCount = service.remove(rno);	//댓글 삭제
		
		if(delCount == 1) {	//delCount가 1이면 삭제 성공
			return new ResponseEntity<>("success", HttpStatus.OK); //HttpStatus 200 반환
		} else {	//실패하면						   //500반환
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//댓글 수정
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH },
					value = "/{rno}",
					consumes = "application/json",
				    produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
								         @PathVariable("rno") Long rno){
		log.info("modify rno : " + rno);
		log.info("vo : " + vo);
		vo.setRno(rno);
		int modCount = service.modify(vo);	//댓글 수정
		
		if(modCount == 1) {	//modCount가 1이면 수정 성공
			return new ResponseEntity<>("success", HttpStatus.OK); //HttpStatus 200 반환
		} else {	//실패하면						   //500반환
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
