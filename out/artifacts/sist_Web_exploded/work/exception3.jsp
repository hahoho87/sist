<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- error page를 지정해주지 않았지만, web.xml에서 지정해준 error page 출력 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exception2.jsp</title>
</head>
<body>
	<h3>exception</h3>
	<%out.print(3 / 0);%>
	
</body>
</html>