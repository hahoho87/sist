<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUpload.jsp</title>
</head>
<body>
	<h3>fileUpload.jsp</h3>
	<form action="/webex/SingleUpload.do" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="usernm"><br>
	<%	
		String usernm = request.getParameter("usernm");
		request.setAttribute("userNm", usernm);
	%>
	사진 : <input type="file" name="photo"><br>
	<%	
		String fileName = request.getParameter("file");
		request.setAttribute("fileName", fileName);
	%>
		  <input type="submit" value="전송">
	</form>
</body>
</html>