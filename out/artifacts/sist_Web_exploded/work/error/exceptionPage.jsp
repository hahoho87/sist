<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exceptionPage.jsp</title>
</head>
<body>
	<h3>error occured</h3>
	페이지 처리 중 에러가 발생했습니다.<br>
	관리자에게 문의해주세요. <br />
	[에러 타입] : <%=exception.getClass().getName() %> <br />
	[에러 내용] : <%=exception.getMessage() %>
	
</body>
</html>