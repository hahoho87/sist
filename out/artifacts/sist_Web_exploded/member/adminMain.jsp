<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminMain.jsp</title>
</head>
<body>
	<h3>
		ADMIN MAIN PAGE
	<jsp:include page="../include/loginChk.jsp" />
	</h3>
	<jsp:include page="../include/adminChk.jsp" />

	<ul>
		<li><a href="/webex/Member.do?flag=a">회원 목록</a></li>
	</ul>

</body>
</html>