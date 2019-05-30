<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUploadResult.jsp</title>
</head>
<body>
	<h3>FILE UPLOAD RESULT</h3>
	이름 : ${usernm}
<br>
	사진 : ${filename}<br>
		<img src="/webex/upload/${filename}">
</body>
</html>