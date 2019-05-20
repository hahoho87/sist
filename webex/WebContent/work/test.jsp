<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test.jsp</title>
</head>
<body>
	<%!
		int num1 = 30;
		int num2 = 40;
		int result = num1 + num2;
	%>
	<!-- !를 붙이면  -->
	<%
		int num11 = 300;
		int num22 = 400;
		int result2 = num11 + num22;
	%>
	3 + 4 =  <% out.println(3+4); %>
	<br>
	5 + 6 = <%= 5 + 6 %><br>
	result = <%= result %><br>
	result2 = <%= result2 %>
</body>
</html>