<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error_page.jsp</title>
</head>
<body>
	<h3>${exception.getMessage() }</h3>
	<ul>
		<c:forEach items="${exception.getStackTrace() }"
				   var="stack">
			<li>${stack }</li>
		</c:forEach>	
	</ul>
</body>
</html>