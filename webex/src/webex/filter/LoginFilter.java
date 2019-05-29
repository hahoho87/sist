package webex.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/member/main.jsp")
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//로그인하지 않은 경우 걸러내기
		System.out.println("LoginFilter Begin");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		//세션 객체 생성
		HttpSession session = httpReq.getSession();
		String sid = (String) session.getAttribute("sid");
		//세선의 sid가 null이면, 회원 전용 페이지 알림 메시지를 요청객체의 msg 속성에 저장한 후
		//로그인 페이지로 이동
		if (sid == null) {
			httpReq.setAttribute("msg", "회원 전용 페이지입니다.<br>로그인 후 이용해주세요.");
			String url = "/member/join03.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(httpReq, httpRes);
		} 
		
		chain.doFilter(request, response);
		System.out.println("LoginFilter Done");
		//로그인한 경우 화면 출력
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter init()");
	}

}
