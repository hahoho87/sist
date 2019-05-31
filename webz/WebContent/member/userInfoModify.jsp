<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfoModify.jsp</title>
<script>
	function setEmail2(email3Obj) {
		var email2 = document.frm.email2;
		var email3 = email3Obj.value;

		if (email3 != 'direct') { //직접 선택이 아닌 경우
			email2.value = email3;
		} else {//직접 선택인 경우
			email2.value = "";
			email2.focus();
		}
	}
</script>
</head>
<body>
	<h3>USER INFO MODIFY PAGE
	<jsp:include page="/common/logout.jsp" /></h3>
	<jsp:useBean id="mvo" class="webz.vo.MemberVO" scope="request" />
	<c:if test="${ !empty mvo }">
		<p class="msg">
			<c:if test="${ !empty msg }">${msg}</c:if>
		</p>

		<form action="/webz/Main.do" method="post" id="frm" name="frm" enctype="multipart/form-data">
			<input type="hidden" name="flag" value="u"> 
			<input type="hidden" name="userId" value="${ mvo.userId }"> 
			<input type="hidden" name="photoBefore" value="${mvo.photo }"> 
			아이디 : ${ mvo.userId }<br> 
			이름 : ${ mvo.userNm }<br> 
			이메일 : <input type="text" name="email1" value="${ mvo.email1 }">@<input type="text" name="email2" value="${ mvo.email2 }">
			<select name="email3" onchange="setEmail2(this)">
				<option value="direct" selected>직접입력</option>
				<option value="gmail.com">gmail.com</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
			</select>
			<br> 가입일자 : ${ mvo.regDate }<br> 생년월일 : ${ mvo.birthDate }
			<!-- << 이렇게 쓰거나 -->
			<br> 
			사진 : <jsp:getProperty property="photo" name="mvo" /><br>
			<img src="/webz/upload/
			<jsp:getProperty property="photo" name="mvo" />">
			<input type="file" name="photo" value="${ mvo.photo }">
			<hr>
			<button type="button" onclick="history.back()">이전으로</button>
			<button type="reset">다시쓰기</button>
			<button type="submit">완료</button>
		</form>
	</c:if>

</body>
</html>
