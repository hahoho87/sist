<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//아이디와 비밀번호를 id, pw 변수에 저장

	boolean result = true;
	String id = request.getParameter("userId");
	String pw = request.getParameter("userPw");

	//result가 true이면 main.jsp로 이동
	if (result) {
		//요청 객채의 msg 속성에 로그인 성공 메시지 저장
		request.setAttribute("msgReq", "request login succuss");
		session.setAttribute("msgSess", "session login success");
		application.setAttribute("msgApp", "application login success");
		//redirect를 하면 기존에 있던 request 객체는 사라지기 때문에
		//session과 application 에 저장한 msg만 출력된다
		response.sendRedirect("main.jsp");
	} else {
		//그렇지 않으면 login.jsp로 이동
		//단, 요청 객체의 msg 속성에 로그인 실패 메시지 저장
		request.setAttribute("msgReq", "request login failed");
		session.setAttribute("msgSess", "session login failed");
		application.setAttribute("msgApp", " application login failed");

		/* 
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response); 
		*/
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>




