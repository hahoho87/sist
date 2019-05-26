<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exception.jsp</title>
</head>
<body>
	<h3>exception</h3>
	<%
		try {
			out.print(3 / 0);
		} catch (Exception e) {
			out.print("<H4>예외발생</H4><br>관리자에게 문의 요망!");
		}
	%>

</body>
</html>