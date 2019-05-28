<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<c:if test="${ !empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>

	<h3>WEBEX index page</h3>
	<ul>
		<li><a href="member/join01.jsp">Sign-up</a></li>
		<li><a href="/HelloServlet.do">HelloServlet</a></li>
		<li><a href="/webex/HelloServlet.do?usernm=abc">/webex/HelloServlet</a></li>
		<li><form action="/webex/HelloServlet.do">
				<!-- method를 안쓰면 get방식 -->
				<input type="text" name="usernm"> <input type="submit"
					value="Hello GET">
			</form></li>
	</ul>
	<ul>
		<li><form method="post" action="/webex/HelloServlet.do">
				<!-- method="post"라고 지정해줘야 post방식을 전송 -->
				<input type="text" name="usernm"> <input type="submit"
					value="Hello POST">
			</form></li>
	</ul>
</body>
</html>