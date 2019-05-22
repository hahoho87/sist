<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/exceptionPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exception2.jsp</title>
</head>
<body>
	<h3>exception</h3>
	<%out.print(3 / 0);%>
</body>
</html>