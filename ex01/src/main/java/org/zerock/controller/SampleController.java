package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	//실제 업로드 처리
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("-------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
	
	//업로드 화면을 처리(jsp 출력만 담당)
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload......");
	}
	
	//ResponseEntity 타입
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.........");
		
		// {"name" : "KIM"}s
		String msg = "{\"name\" : \"KIM\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	//JSON 객체 생성
	//pom에서 jackson-databind 추가해야 한다
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("Lee");
		
		return dto;
	}
	
	//void는 매핑된 url 경로를 그대로 jsp파일의 이름으로 사용
	//String의 경우 return으로 지정
	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05....");
	}
	
	//ex04는 페이지번호는 파라미터로 전달하지만, 결과 데이터를 전달하려면 Model에 담아서 전달해야 한다
	//기본 자료형(int page_의 경우는 파라미터로 선언하더라도 기본적으로 화면까지 전달되지는 않는다
	//ModelAttribute가 붙은 파라미터는 화면까지 전달
	@GetMapping("/ex04_2")
	public String ex04_2(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		
		return "/sample/ex04";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		
		return "/sample/ex04";
	}

	// TodoDTO에서 DateTimeFormat 적용했기 때문에 InitBinder는 사용하지 않아도 된다.
//	// String을 받아서 Date 객체로 변환하는 InitBinder
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}

	@RequestMapping("")
	public void basic() {
		log.info("basic......");
	}

	// 기존의 get, post 방식 지정
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get............");
	}

	// Spring 4.3 이후의 get, post 방식 지정
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get..........");
	}

	// DTO 객채 수집
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto : " + dto);
		return "ex01";
	}

	// parameter의 타입만을 맞게 선언해 주는 방식
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}

	// List parameter 수집
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}

	// 배열 parameter 수집 - for문으로 돌려주거나 toString을 하여 값을 꺼내줘야 한다
	@GetMapping("/ex02Array")
	public String ex03Array(@RequestParam("ids") String[] ids) {
		log.info("ids : " + Arrays.toString(ids));
		return "ex02Array";
	}

	// 객체 리스트
	// Tomcat 버전에 따라 대괄호를 인식 못하기 때문에 인코딩해서 값 입력
	// http://localhost:8090/sample/ex02Bean?list%5b0%5d.name=aaa&list%5b1%5d.name=bbb&list%5b2%5d.name=ccc
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dto : " + list);
		return "ex02Bean";
	}

}
