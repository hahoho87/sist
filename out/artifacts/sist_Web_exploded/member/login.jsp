<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<h3>user login page</h3>
	<%
		//요청 객체의 msg 속성의 값을 msg 변수에 저장
		String msgReq = (String) request.getAttribute("msgReq");
		String msgSess = (String) session.getAttribute("msgSess");
		String msgApp = (String) application.getAttribute("msgApp");
		if (msgReq != null) {
			out.print(msgReq + "<br>");
		}
		if (msgSess != null) {
			out.print(msgSess + "<br>");
		}
		if (msgApp != null) {
			out.print(msgApp + "<br>");
		}
	%>
	<form action="loginProc.jsp" method="post">
		ID : <input type="text" name="userId"><br> PW : <input
			type="text" name="userPw"> <input type="submit" value="로그인">
	</form>
	<hr>
</body>
</html>

<% 
	session.removeAttribute("msgSess");
	application.removeAttribute("msgApp");
	// 계속 남아있기 때문에 브라우저 종료시 제거
%>