package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
							            HttpServletResponse response,
							            Authentication auth) 
							      throws IOException, ServletException {
		log.warn("Login success!");
		
		List<String> roleNames 
			= new ArrayList<String>();	//사용자 권한 저장 리스트
		auth.getAuthorities().forEach(authority -> {
			//사용자 권한을 모두 리스트에 저장
			roleNames.add(authority.getAuthority()); 
		});
		log.warn("ROLE NAMES : " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {  //ROLE_ADMIN이면
			// /sample/admin으로
			response.sendRedirect("/sample/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) { //ROLE_MEMBER이면
			// /sample/member로
			response.sendRedirect("/sample/member");
			return;
		}
		
		//위 두 ROLE이 아니면 /로 이동
		response.sendRedirect("/");
	}

}


















