<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: -5px auto;
	width: 1000px;
}

h3 {
	text-align: center;
}

ul {
	border-bottom: 3px solid black;
}

ul li {
	width: 30%;
	display: inline-block;
	text-align: center;
}

.suc {
	text-align: center;
	font-size: 1.5em;
	font-weight: bold;
	width: 600px;
	height: 100px;
	position: relative;
	left: 200px;
	top: 100px;
}

.login {
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	width: 300px;
	position: relative;
	top: 100px;
	left: 350px;
}

form {
	padding: 30px;
}

button {
	position: relative;
	left: 100px;
	top: 10px;
}
.suc {
	color: red;
}
</style>
</head>
<body>

	<h3>회원가입</h3>
	<hr>
	<ul>
		<li>약관 동의</li>
		<li>정보 입력</li>
		<li
			style="border: 3px solid black; margin-bottom: -3px; background: lightgray;">가입
			완료</li>
	</ul>

	<div class="suc">
		<span>
			<%
				String msg = (String) request.getAttribute("msg");
				if (msg != null) {
					out.print("<br>" + msg);
				}
			%>
		</span>
	</div>

	<div class="login">

		<form action="userMain.html" method="post">
			<label for="id">아이디&nbsp;&nbsp;&nbsp;</label> <input type="text"
				id="id" name="id" required><br> <label for="pwd">비밀번호</label>
			<input type="password" id="pwd" name="pwd" required>

			<button type="submit">로그인</button>

		</form>

	</div>
</body>
</html>