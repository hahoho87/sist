<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//폼 입력 데이터 확인 함수
function frmCheck(){
	var id = document.frm.id; 
	var pwd = document.frm.pwd; 
	var pwd2 = document.frm.pwd2; 
	
	if( id.value == '') {
		alert('아이디를 입력해 주세요');
		id.focus();
	} else if(id.value.length < 10 || id.value.length > 15) {
		alert('아이디는 10자 이상 15자 이내로 입력해 주세요');
		id.focus();
		return;
	} else if( pwd.value == ''){
		alert('비밀번호를 입력해 주세요');
		pwd.focus();
	} else if( pwd2.value == ''){
		alert('비밀번호 확인을 입력해 주세요');
		pwd2.focus();
	} else if( pwd.value !== pwd2.value ){
		alert('비밀번호가 일치하지 않습니다.');	
		//비밀번호 값을 모두 지우기
		pwd.value = "";
		pwd2.value = '';
		pwd.focus();
	}
	
	document.frm.submit();
	
}//END frmCheck()

function setEmail2(email3Obj){
	var email2 = document.frm.email2;
	var email3 = email3Obj.value;
	
	if(email3 != 'direct'){	//직접 선택이 아닌 경우
		email2.value = email3;
	} else {//직접 선택인 경우
		email2.value = "";
		email2.focus();
	}
}
</script>
<link rel="stylesheet" href="../style/style.css">
<!-- <style>
h3 {
	text-align: center;
}

body {
	margin: -5px auto;
	width: 1000px;
}

button {
	float: right;
	margin: 5px;
	position: relative;
	top: 50px;
}

ul {
	border-bottom: 3px solid black;
}

ul li {
	width: 30%;
	display: inline-block;
	text-align: center;
}

form {
	width: 800px;
	position: relative;
	left: 100px;
	top: 20px;
}

legend {
	font-weight: bold;
	font-size: 1.5em;
}

.msg {
	color: red;
}
</style> -->
</head>
<body>
	<h3>회원가입</h3>
	<hr>
	<ul>
		<li>약관 동의</li>
		<li style="background: lightgray; border: 3px solid black; margin-bottom: -3px;">정보 입력</li>
		<li>가입 완료</li>
	</ul>
	<!-- <form action="joinProc.jsp" method="post" name="frm"> -->
	<form action="/webz/Main.do" method="post" name="frm" enctype="multipart/form-data">
		<input type="hidden" name="flag" value="i"> <span class="msg"> <%
 	String msg = (String) request.getAttribute("msg");
 	if (msg != null) {
 		out.print(msg);
 	}
 %></span>
		<fieldset>
			<legend>필수사항</legend>
			아이디 <input type="text" name="userId" placeholder="10~15자 이내 영문과 숫자로"><br> 
			비밀번호 <input type="password" name="userPw" placeholder="10~20자 이내 영문과 숫자로"><br> 
			비밀번호 확인<input type="password" name="pwd2" placeholder="10~20자 이내 영문과 숫자로"><br> 
			이름 <input type="text" name="userNm"><br> 
			이메일 <input type="text" name="email1">@ <input type="text" name="email2">
			<select name="email3" onchange="setEmail2(this)">
				<option value="direct" selected>직접입력</option>
				<option value="gmail.com">gmail.com</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
			</select>
			<br> 생년월일 <input type="date" name="birthDate"><br> 
			성별 <input id="female" type="radio" name="gender" value="F"> 
				<label for="female">여자</label> 
				<input id="male" type="radio" name="gender" value="M"> 
				<label for="male">남자</label>
		</fieldset>
		<fieldset>
			<legend>선택사항</legend>
			사진 : <input type="file" name="photo">
			<%	
				String fileName = request.getParameter("file");
				request.setAttribute("fileName", fileName);
			%>
		</fieldset>
		<button type="submit">다음으로</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>