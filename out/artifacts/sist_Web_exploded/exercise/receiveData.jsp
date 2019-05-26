<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>receiveData.jsp</title>
</head>
<style>
	body {
	background : <%=request.getAttribute("color") %>
	}
</style>
<body>
	<h3>RECEIVE DATA</h3>
	<form>
		name : <%= request.getAttribute("name") %><br>
		blood type : <%= request.getAttribute("bloodType") %><br> 
		color type : <%=request.getAttribute("color") %> 	<br>
	</form>
</body>
</html>