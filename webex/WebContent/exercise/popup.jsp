<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>popup.jsp</title>
<script>
	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setSeconds(todayDate.getSeconds() + expiredays);

		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ todayDate.toGMTString() + ";";
	}
</script>
<style>
#container {
	margin-top: 100px;
}
</style>
</head>
<body>
	<h3>popup.jsp</h3>
	<div id="container">
		<input type="checkbox" id="yesNo" name="yseNo" onclick="cls()" /> 오늘 하루 안 보기 
		<input type="button" value="CLOSE" onclick="self.close();" />
	</div>
	<script>
		function cls() {
			if (document.getElementById("yesNo").checked) {
				setCookie("yesNo", "yes", 10);
				self.close();
			}
		}
	</script>
</body>
</html>
