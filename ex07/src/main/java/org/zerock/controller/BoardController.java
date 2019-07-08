package org.zerock.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;

	// 전체 목록 가져오기
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list");
//		model.addAttribute("list", service.getList());
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		// 전체 데이터 수는 임의로 123으로 지정
		// 전체 데이터 개수를 가지고 와서 total에 저장
		int total = service.getTotal(cri);
		log.info("total count : " + total); // 전체 데이터 개수 로그로 기록
		// 모델 객체 pageMaker의 값을 실제 총 데이터 개수로 지정해서 저장
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	// 게시물 하나 가져오기
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get or modify : " + bno);
		model.addAttribute("board", service.get(bno));
	}

	// 게시물 수정하기
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : " + board);

		if (service.modify(board)) { // 수정에 성공한 경우
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());	//페이지 번호 추가
//		rttr.addAttribute("amount", cri.getAmount());	//게시물 표시 개수 추가
//		rttr.addAttribute("type", cri.getType());		//검색 조건 추가
//		rttr.addAttribute("keyword", cri.getKeyword());	//검색 키워 추가
		return "redirect:/board/list";
	}

	// 게시물 삭제하기
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove : " + bno);
		
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		
		if (service.remove(bno)) { // 삭제에 성공한 경우
			deleteFiles(attachList);
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());	//페이지 번호 추가
//		rttr.addAttribute("amount", cri.getAmount());	//게시물 표시 개수 추가
//		rttr.addAttribute("type", cri.getType());		//검색 조건 추가
//		rttr.addAttribute("keyword", cri.getKeyword());	//검색 키워 추가
		return "redirect:/board/list" + cri.getListLink();
	}

	// 게시물 등록화면 이동
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void register() {

	}

	// 게시물 등록하기
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board);

		log.info("===========================");
		if (board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		log.info("===========================");

		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
	}

	// 첨부파일 출력
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno) {
		log.info("getAttachList : " + bno);

		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}

	// 파일 삭제 처리
	private void deleteFiles(List<BoardAttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files.............");
		log.info(attachList);
		
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
						"C:\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid() + "_" + attach.getFileName());
					
					Files.delete(thumbNail);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}//END catch

		});//END forEach

	}
}
