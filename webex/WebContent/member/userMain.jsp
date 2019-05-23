<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userMain.jsp</title>
</head>
<body>
	<%
		if (session.getAttribute("sid") != null) {
	%>
	<%=session.getAttribute("sid")%>님 안녕하세요!
	<br>
	<jsp:include page="../include/loginChk.jsp"></jsp:include>
	<%
		} else {
	%>
	<script>
		alert("회원 전용 페이지입니다. 로그인 후 이용해주세요.");
		location.href("join03.jsp");
	</script>
	<%
		}
	%>
</body>
</html>