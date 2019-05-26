<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionResult.jsp</title>
</head>
<body>
	<h3>SESSION RESULT</h3>
	name : <%= session.getAttribute("name") %><br>
	blood-type : <%= session.getAttribute("bloodType") %><br>
	
	<input type="button" value="logout" onclick="confirmBtn()">
	<script>
		function confirmBtn() {
			
			if (confirm("정말 로그아웃 하시겠습니까?") == true) {
				location.href="exercise/sessionLogout.jsp"
			} 
		}
	</script>
</body>
</html>