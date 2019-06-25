<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customLogin.jsp</title>
</head>
<body>
	<h3>Custom Login Page</h3>
	<h4 style="color:red"><c:out value="${error }"/></h4>
	<h4 style="color:red"><c:out value="${logout }"/></h4>
	
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" value="admin90">
		</div>
		<div>
			<input type="password" name="password" value="pw90">
		</div>
		<div>
			<input type="checkbox" name="remember-me"> Rememeber Me
		</div>
		<div>
			<input type="submit">
		</div>
		<input type="hidden"
			   name="${_csrf.parameterName }"
			   value="${_csrf.token }">
	</form>
</body>
</html>














