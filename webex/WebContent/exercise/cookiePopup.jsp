<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open.html</title>
<script>
	function popupOpen() {
		window.open('popup.jsp', '_blank', 'width=350, height=250, left=900, top=200');
	}
</script>
</head>
<body onload="popupOpen()">
	<h3>COOKIE POPUP</h3>
	yesNo : <%=request.getParameter("yesno") %>
	<jsp:useBean id="cookieBean" class="webex.vo.MyBeans"></jsp:useBean>
	<jsp:setProperty property="name" name="cookieBean" />
	<jsp:getProperty property="name" name="cookieBean"></jsp:getProperty>
	<%
		Cookie nameCookie = new Cookie("name", request.getParameter("name"));
		nameCookie.setMaxAge(2 * 60); //쿠키 유효시간 설정 - 2min
		response.addCookie(nameCookie); //응답객체에 쿠키 추가
	%>
</body>
</html>