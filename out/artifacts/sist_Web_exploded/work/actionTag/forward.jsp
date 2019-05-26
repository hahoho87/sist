<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>ACTION TAG : forward</h3>
	<jsp:forward page="../directive.jsp">
		<jsp:param value="Lee" name="username" />
	</jsp:forward>
	
</body>
</html>