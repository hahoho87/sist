<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>join01.jsp</title>
<link rel="stylesheet" href="../style/style.css">
<script>
	function agreeChk() {
		var chk = document.agreeFrm.agree.checked;
		if (!chk) {
			alert("약관에 동의해주세요");
			return false;
		}
	}
</script>
</head>

<body>
	<header>
		<h1>회원가입</h1>
	</header>
	<section>
		<div id="nav">
			<ul>
				<li id="agree">약관동의</li>
				<li id="signup">정보입력</li>
				<li id="signupcomplete">가입완료</li>
			</ul>
		</div>
		<div id="terms">
			<br>
			<textarea rows="30" cols="30" readonly></textarea>
		</div>
		<form action="join02.jsp" method="get" name="agreeFrm" id="agreeFrm" onsubmit="return agreeChk(this)">
			<br> <input type="checkbox" name="agree" id="agreeConfirm"> 
			<label for="agreeConfirm">약관에 동의합니다.</label> <br> 
			<div id="agreementBtns">
			<input type="reset" value="취소" class="buttons" /> 
			<input type="submit" value="확인" class="buttons" />
			</div>
		</form>
	</section>
</body>
</html>
