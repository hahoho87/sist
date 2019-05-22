<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
	
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>setCookie.jsp</title>
</head>
<body>
	<h3>SET COOKIE</h3>
	<jsp:useBean id="cookieBean" class="webex.vo.MyBeans"></jsp:useBean>
	<jsp:setProperty property="name" name="cookieBean" />
	cookie name : <jsp:getProperty property="name" name="cookieBean"></jsp:getProperty>
	<% 
		//쿠키 생성
		//쿠키의 이름은 name, 값음 parameter로 전송된 name 지정
		Cookie nameCookie = new Cookie("name", request.getParameter("name"));
		nameCookie.setMaxAge(2 * 60);	//쿠키 유효시간 설정 - 2min
		response.addCookie(nameCookie);	//응답객체에 쿠키 추가
		%>
		<hr />	
		<br><a href="getCookie.jsp">GET COOKIE</a>
</body>
</html>