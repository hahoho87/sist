<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sendData.jsp</title>
</head>
<body>
	<h3>SEND DATA</h3>
	<form action="src/webex/controller/Session.java">
	name : <input type="text" name="name"><br>
	blood type : <input type="radio" name="bloodType" id="a" value="A"><label for="a">A</label>
				<input type="radio" name="bloodType" id="b" value="B"><label for="b">B</label>
				<input type="radio" name="bloodType" id="ab" value="AB"><label for="ab">AB</label>
				<input type="radio" name="bloodType" id="o" value="O"><label for="o">O</label>
				<hr>
				<input type="submit" value="send">
	</form>
</body>
</html>