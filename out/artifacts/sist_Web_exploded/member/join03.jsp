<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

.msg {
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
		<li style="border: 3px solid black; margin-bottom: -3px; background: lightgray;">가입 완료</li>
	</ul>
	<div class="suc">
		<span class="msg"> <%
 	String msg = (String) request.getAttribute("msg");
 	if (msg != null) {
 		out.print(msg);
 	}
 %>
		</span>
	</div>
	<div class="login">
		<form action="/webex/Login.do" method="post">
			<label for="id">아이디&nbsp;&nbsp;&nbsp;</label> 
			<input type="text" id="id" name="userId" required><br> 
			<label for="pwd">비밀번호</label> 
			<input type="password" id="pwd" name="userPw" required>
			<button type="submit">로그인</button>
		</form>
		<pre>
<!--  
 1. 입력받은 아이디와 비밀번호를 LoginServlet으로 전송
 2. LoginServlet에서 입력받은 아이디와 비밀번호를
 	요청객체의 파라미터에서 꺼낸 후 MemberVO에 저장한 후
	MemberDao의 loginChk() 호출
 3. loginChk() 호출 결과가 true이면
	> 입력받은 아이디를 세션의 sid 속성에 저장한 후
	> member/userMain.jsp로 이동
	그렇지 않으면   
	> 요청 객체의 msg 속성에 로그인 실패 메시지를 저장한 후
	> join03.jsp로 이동
 4. userMain.jsp 페이지에서
    > 세션의 sid 속성에 값이 있으면
    > logout 버튼 출력하고,
    > logout 버튼이 눌리면 
    > 로그아웃 의사를 확인한 후 logout.jsp로 이동 
	    >>>>>> include/loginChk.jsp를
	    >>>>>> 액션태그를 이용하여 include하여 처리
    > 세션 무효화 처리 후 첫 화면으로 이동 
 	> (선택 작업) 로그인 후 1분간 아무런 작업이 없으면
 	> 자동 로그아웃 알림 메시지 출력
 	
 	> 세션의 sid 속성이 없으면
 	> 회원 전용 페이지 알림 메시지 출력 후 로그인 화면으로 이동
 	-->
</pre>
	</div>
</body>
</html>














