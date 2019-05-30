<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join03.html</title>
<link rel="stylesheet" href="../style/style.css">
<!-- <style>
body {
	margin: 50px auto;
	width: 800px;
	text-align: center;
}

header {
	margin-left: 30px
}

#nav {
	margin-left: 120px;
}

#nav ul {
	list-style: none;
}

#nav ul li {
	float: left;
	width: 147px;
	margin-right: px;
	border-top: 1px solid black;
	border-left: 1px solid black;
	border-bottom: 1px solid black;
	text-align: center;
	padding: 10px;
}

#signupcomplete {
	background: pink;
}

#nav ul li[id="signupcomplete"] {
	font-weight: bold;
}

#nav ul li[id="signupcomplete"] {
	border-right: 1px solid black;
}

h, td, tr, input, textarea, select, form {
	font-size: 1em;
	border-radius: 5px;
}

fieldset {
	margin-left: 40px;
	width: 600px;
	text-align: left;
}

table, form {
	border-spacing: 15px;
}

#completeMassage {
	clear: both;
	font-weight: bold;
	font-size: 23px;
}

.line {
	width: 300px;
}

#loginButton input {
	height: 70px;
}
</style> -->


</head>

<body>
	<header>
		<h1>회원가입</h1>
	</header>
	<section>
		<nav id="nav">
			<ul>
				<li id="agree">약관동의</li>
				<li id="signup">정보입력</li>
				<li id="signupcomplete">가입완료</li>
			</ul>
		</nav>
		<div id="login">
			<br> 
			<hr class="line">
		<jsp:include page="login.jsp"/>
			<hr class="line">
		</div>
	</section>
</body>
</html>