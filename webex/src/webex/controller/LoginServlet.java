package webex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webex.dao.MemberDao;
import webex.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberVO mvo = new MemberVO(userId, userPw);
		MemberDao mdao = new MemberDao();
		boolean result = mdao.loginChk(mvo);	//DB 쿼리 실행 메서드 호출
		String url = "";
		if(result == true) {	//userMain.jsp로 이동
			HttpSession session = request.getSession();
			session.setAttribute("sid", userId);
			url = "member/userMain.jsp";	//url을 userMain.jsp로 지정
			if(userId.equals("admin")) {
				url = "member/adminMain.jsp";
			}
		} else {				//join03.jsp로 이동
			request.setAttribute("msg", "아이디 또는 비밀번호 불일치<br>다시 시도해 주세요");
			url = "member/join03.jsp";	//url을 join03.jsp로 지정
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); //RequestDispatcher를 이용하여 지정된 url로 포워딩
	}

}