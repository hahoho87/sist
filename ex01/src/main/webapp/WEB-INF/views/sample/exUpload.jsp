<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PULBIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.rog/TR/html4/loose.dtd>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>exUpload.jsp</title>
</head>
<body>
	<h3>File Upload in Spring</h3>
	<form action="/sample/exUploadPost" method="post" enctype=multipart/form-data>

			<input type="file" name="files" /><br>
			<input type="file" name="files" /><br>
			<input type="file" name="files" /><br>
			<input type="file" name="files" /><br>
			<input type="file" name="files" /><br>
			<input type="submit" />

	</form>
</body>
</html>