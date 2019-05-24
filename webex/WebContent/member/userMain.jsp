<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userMain.jsp</title>
<script>
	if (session.getAttribute("sid") == null) {
		alert("회원 전용 페이지입니다. 로그인 후 이용해주세요.");
		location.href("join03.jsp");
	}
</script>
</head>
<body>
	<h3>USER MAIN PAGE</h3>
	<jsp:include page="../include/loginChk.jsp"></jsp:include>
	<hr>
	<ul>
		<li>
		<a href="/webex/Member.do?flag=s&userId=<%=session.getAttribute("sid")%>">
		내 정보 보기</a>
		</li>
	</ul>
</body>
</html>