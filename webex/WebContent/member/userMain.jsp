<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userMain.jsp</title>
</head>
<body>
	<h3>
		USER MAIN PAGE
		<jsp:include page="../include/loginChk.jsp" />
	</h3>
	<ul>
		<li><a href="/webex/Member.do?flag=s&userId=<%=session.getAttribute("sid")%>">내 정보 보기</a></li>
	</ul>
</body>
</html>














