<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getCookie.jsp</title>
</head>
<body>
	<h3>GET COOKIE</h3>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length >0) {
			for (int i = 0; i < cookies.length; i++) {
				out.print("쿠키 이름 : " + cookies[i].getName() + 
						" | 값 : " + cookies[i].getValue() + "<BR>");
			} 
		}
	%>
</body>
</html>