<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="loginChk.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<h3>user main page</h3>
	<%
		String msgReq = (String) request.getAttribute("msgReq");
		String msgSess = (String) session.getAttribute("msgSess");
		String msgApp = (String) application.getAttribute("msgApp");
		
		if (msgReq != null) { out.print("<br>" + msgReq); }
		if (msgSess != null) { out.print("<br>" + msgSess); }
		if (msgApp != null) { out.print("<br>" + msgApp); }

	%>
</body>
</html>