package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	
	//전체 목록 가져오기
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list");
//		model.addAttribute("list", service.getList());
		model.addAttribute("list", service.getList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 123));
										//전체 데이터 수는 임의로 123으로 지정
		//전체 데이터 개수를 가지고 와서 total에 저장
		int total = service.getToTal(cri);
		//전체 data 개수 log로 기록
		log.info("total : " + total);
		//model객체 pageMaker의 값을 실제 총 데이터 개수로 지정해서 저장
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	//게시물 등록
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board);
		
		service.register(board);
		//addFlashAttribute로 보관된 데이터는 일회성으로 한 번만 사용할 수 있게 보관
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	//게시물 등록화면 이동
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping({"/get", "/modify"})
	
	public void get(@RequestParam("bno") Long bno, 
					@ModelAttribute("cri") Criteria cri, Model model) {
					//@ModelAttribute를 통해 자동으로 Model에 데이터를 지정한 이름으로 담아준다
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, 
						 @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("reuslt", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, 
						 @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove...." + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "seccess");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
}
