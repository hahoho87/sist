<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userMain.jsp</title>
</head>
<body>
	<span class="msg">
	<c:if test="${ !empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	</span>
	<h3>USER MAIN PAGE
	<jsp:include page="/common/logout.jsp" />
	</h3>
	
	<c:url var="userInfoPage" value="Main.do">
		<c:param name="userId" value="${ sid }"/>
		<c:param name="flag" value="s"/>
	</c:url>
	<ul>
		<li><a href="${ userInfoPage }">내 정보 보기</a></li>
	</ul>
</body>
</html>