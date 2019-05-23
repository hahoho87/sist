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

@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		HttpSession session = request.getSession();
		
		MemberVO mvo = new MemberVO(userId, userPw);
		MemberDao mdao = new MemberDao();
		boolean result = mdao.loginChk(mvo);
		String url = "";
		System.out.println(result);
		if (result==true) {
			session.setAttribute("sid", userId);
			url = "member/userMain.jsp";
		} else {
			request.setAttribute("msg", "LOGIN FAILED");
			url = "member/join03.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
