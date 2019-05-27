<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>elObjecView.jsp</title>
</head>
<body>
<h3>EL OBJECT VIEW</h3>
<%
    pageContext.setAttribute("data", "PAGE_CONTEXT");
%>

	data : ${ data }<br>
	pageScope.data : ${ pageScope.data }<br>
	requestScope.data : ${ requestScope.data }<br>
	sessionScope.data : ${ sessionScope.data }<br>
	applicationScope.data : ${ applicationScope.data }<br>
	cookie.data.value : ${ cookie.data.value }<br><br>
	
	param.data  : ${ param.data }<br>
	paramValues : ${ paramValues.animal[0] }<br>
	paramValues : ${ paramValues.animal[1] }<br> 
	paramValues : ${ paramValues.animal[2] }<br><br>
	
	header.host				: ${header.host}<br>
	header.user-agent 		: ${header["User-Agent"]}<br>
	headerValues.Accept  	: ${headerValues.Accept}<br>
	headerValues.Accept[0]  : ${headerValues.Accept[0]}<br><br>
	
	initParma.database : ${ initParam.database } <br>
</body>
</html>