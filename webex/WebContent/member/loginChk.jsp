<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean sessionId = true;
	
	if(sessionId == false) {  //세션에 아이디가 들어 있지 않으면(false)
%>		<script>
			alert('로그인 후 이용해 주세요.');
			location.href='login.jsp';
		</script>
<%	} else { %>
		<script>
			alert('로그인 ok');
		</script>
<%  } %>
