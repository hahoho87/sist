<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo.jsp</title>
<link rel="stylesheet" href="/webz/style/style.css">
</head>
<body>
	<h3>USER INFO PAGE
		<jsp:include page="/common/logout.jsp" /></h3>
		<jsp:useBean id="mvo" class="webz.vo.MemberVO" scope="request" />
	<p class="msg">
		<c:if test="${ !empty msg }">${msg}</c:if>
	</p>
	<c:if test="${ !empty mvo }">
	아이디 : <jsp:getProperty property="userId" name="mvo" /><br> 
	이름 : <jsp:getProperty property="userNm" name="mvo" /><br> 
	이메일 : <jsp:getProperty property="email1" name="mvo" />@<jsp:getProperty property="email2" name="mvo" /><br> 
	가입일자 : <jsp:getProperty property="regDate" name="mvo" /><br> 
	생년월일 : <jsp:getProperty property="birthDate" name="mvo" /><br>
	사진 : <jsp:getProperty property="photo" name="mvo" /><br>
		<img src="/webz/upload/<jsp:getProperty property="photo" name="mvo" />">
	<hr>
	<c:url var="delete" value="Main.do">
		<c:param name="userId" value="${ mvo.userId }"/>
		<c:param name="flag" value="d"/>
	</c:url>
	<script>
	function deleteChk(gubun) {
		var result = confirm("정말 " + gubun + " 하시겠습니까?")
		if (result) {
			location.href="${delete}";
		}
	}
	
</script>
	<c:choose>
		<c:when test="${ sid eq 'admin' }">
		<c:set var="gubun" value="삭제"/>
		</c:when>
		<c:otherwise>
		<c:set var="gubun" value="탈퇴"/>
		</c:otherwise>
	</c:choose>
	<c:url var="modify" value="Main.do">
		<c:param name="userId" value="${ mvo.userId }"/>
		<c:param name="flag" value="uf"/>
	</c:url>
 	<button type="button" onclick="history.back()">이전으로</button>
	<button type="button" onclick="deleteChk('${ gubun }')">${ gubun }</button>
	<button type="button" id="deleteBtn" onclick="location.href='${ modify }'">수정</button>
	</c:if>
</body>
</html>