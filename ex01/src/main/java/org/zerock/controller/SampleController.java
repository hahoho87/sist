package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	//String을 받아서 Date 객체로 변환하는 InitBinder
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}	
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}

	@RequestMapping("")
	public void basic() {
		log.info("basic......");
	}

	//기존의 get, post 방식 지정
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get............");
	}
	
	//Spring 4.3 이후의 get, post 방식 지정
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get..........");
	}
	
	//DTO 객채 수집
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto : " + dto);
		return "ex01";
	}
	
	//parameter의 타입만을 맞게 선언해 주는 방식
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	//List parameter 수집
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	
	//배열 parameter 수집 - for문으로 돌려주거나 toString을 하여 값을 꺼내줘야 한다
	@GetMapping("/ex02Array")
	public String ex03Array(@RequestParam("ids") String[] ids) {
		log.info("ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	//객체 리스트
	//Tomcat 버전에 따라 대괄호를 인식 못하기 때문에 인코딩해서 값 입력
	//http://localhost:8090/sample/ex02Bean?list%5b0%5d.name=aaa&list%5b1%5d.name=bbb&list%5b2%5d.name=ccc
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dto : " + list);
		return "ex02Bean";
	}
	

	
	
}
