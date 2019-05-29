<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo.jsp</title>
<style>
	.msg {
		color: red;
	}
</style>
</head>
<body>
	<h3>
		USER INFO PAGE
		<jsp:include page="../include/loginChk.jsp" /></h3>
		<jsp:useBean id="mvo" class="webex.vo.MemberVO" scope="request" />
	<p class="msg">
		<c:if test="${ !empty msg }">${msg}</c:if>
	</p>
	<%
		//이거랑 같은 코드 >> MemberVO mvo = (MemberVO)request.getAttribute("mvo");
		//요청객체의 mvo 속성의 값을 넘겨받아서 널이 아니면 화면에 회원 정보 출력
		if (mvo != null) {
	%>
	아이디 :
	<jsp:getProperty property="userId" name="mvo" /><br> 이름 :
	<jsp:getProperty property="userNm" name="mvo" /><br> 이메일 :
	<jsp:getProperty property="email1" name="mvo" />@<jsp:getProperty property="email2" name="mvo" /><br> 가입일자 :
	<jsp:getProperty property="regDate" name="mvo" /><br> 생년월일 :
	<%
		out.print(mvo.getBirthDate());
	%><!-- << 이렇게 쓰거나 -->
	<br> 사진 :
	<%=mvo.getPhoto()%><!-- << 이렇게 써도 됨 -->
	<hr>
	<script>
	
	function deleteChk(gubun) {
		var result = confirm("정말" + gubun + " 하시겠습니까?")
		if (result) {
			location.href="/webex/Member.do?flag=d&userId=${mvo.userId}";
		}
	}
	
</script>
	<c:choose>
		<c:when test="${sid eq 'admin' }">
		<c:set var="gubun" value="삭제"/>
		</c:when>
		<c:otherwise>
		<c:set var="gubun" value="탈퇴"/>
		</c:otherwise>
	</c:choose>
	<c:url var="modify" value="Member.do">
		<c:param name="userId" value="${ mvo.userId }"/>
		<c:param name="flag" value="uf"/>
	</c:url>
 	<button type="button" onclick="history.back()">이전으로</button>
	<button type="button" onclick="deleteChk('${ gubun }')">${ gubun }</button>
	<button type="button" id="deleteBtn" onclick="location.href='${ modify }'">수정</button>

	<%
		}
	%>
</body>
</html>











