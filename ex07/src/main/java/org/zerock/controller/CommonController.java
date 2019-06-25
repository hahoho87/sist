package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@PostMapping("/customLogout")
	public void logoutPOST() {
		log.info("customLogout POST");
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("customLogout");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, 
						   String logout, 
						   Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", 
								"Login Error! 로그인 계정을 확인해주세요.");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃 완료");
		}
	}
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, 
						     Model model) {
		log.info("access denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
}













