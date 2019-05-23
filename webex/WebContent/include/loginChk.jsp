<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginChk.jsp</title>
<script>
	function logoutChk() {
		if (confirm("정말 로그아웃 하시겠습니까?") == true) {
			location.href = "member/logout.jsp"
		}
	}
</script>
</head>
<body>
	<input type="button" value="LOGOUT" onclick="logoutChk()">
</body>
</html>