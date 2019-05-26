<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Calendar"%>
<%
	Calendar now = Calendar.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directive.jsp</title>
</head>
<body>
	<h3>directive 지시자</h3>
	오늘은
	<%=now.get(Calendar.YEAR)%>년
	<%=now.get(Calendar.MONTH) + 1%>월<%=now.get(Calendar.DAY_OF_MONTH)%>일
	<br>지금 시각은 ~~:~~:~~
	<br />username :
	<%=request.getParameter("username")%></body>
</html>











