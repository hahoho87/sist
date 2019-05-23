package webex.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session.do")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//세션이 새로 만들어졌으면
			//화면에 welcome new session!! 출력
		if(session.isNew()==true) {
			out.append("welcome new session!");
		} else {
			out.append("hi");
		}
		
		
		String name = request.getParameter("name");   // request에서 id 파라미터를 가져온다
		String bloodType = request.getParameter("bloodType");
		
		session.setAttribute("name", name);
		session.setAttribute("bloodType", bloodType);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("exercise/sessionResult.jsp");
		dispatcher.forward(request, response);
	}

}
