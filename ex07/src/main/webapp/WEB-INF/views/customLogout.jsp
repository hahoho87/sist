<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customLogout.jsp</title>
</head>
<body>
	<h3>Custom Logout Page</h3>
	
	<form method="post" action="/customLogout">
		<input type="hidden"
			   name="${_csrf.parameterName }"
			   value="${_csrf.token }">
		<button>LOGOUT</button>
	</form>
</body>
</html>














