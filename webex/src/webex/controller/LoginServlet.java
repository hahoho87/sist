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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberVO mvo = new MemberVO(userId, userPw);
		MemberDao mdao = new MemberDao();
		boolean result = mdao.loginChk(mvo);
		String url = "";
		
		if (result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("sid", userId);
			url = "member/userMain.jsp";
			if (userId.equals("admin")) {
				url = "member/adminMain.jsp";
			}	
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호 불일치<br>다시 시도해 주세요.");
			url = "member/join03.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		//RequestDispatcher을 이용하여 지정된 url로 포워딩
	}
	
	

}