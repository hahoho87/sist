<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet" href="/webz/style/style.css">
</head>
<body>
	<h3>LOGIN PAGE</h3>
	<div class="login">
	<span class="msg">
	<c:if test="${msg != null }">
	${msg }
	</c:if>
	</span>
		<form action="/webz/Main.do" method="post">
		<input type="hidden" name="flag" value="login">
			<label for="id">아이디&nbsp;&nbsp;&nbsp;</label> 
			<input type="text" id="id" name="userId" required><br> 
			<label for="pwd">비밀번호</label> 
			<input type="password" id="pwd" name="userPw" required>
			<button type="submit">로그인</button>
		</form>
	</div>	
</body>
</html>