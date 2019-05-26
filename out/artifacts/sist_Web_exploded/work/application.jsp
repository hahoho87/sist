<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application.jsp</title>
</head>
<body>
	<h3>application</h3>
	<p>
		database :
		<%=application.getInitParameter("database")%><br> serverInfo :
		<%=application.getServerInfo()%><br> 
		MajorVersion :<%=application.getMajorVersion()%><br> 
		MinorVersion :<%=application.getMinorVersion()%></p>
	
	<%System.out.println("application.jsp");
	   application.log("application.log");%><br>
	<%String path = application.getInitParameter("filepath");%>
	upload file path : <%=path%>
	real file path : <%= application.getRealPath(path) %>

</body>
</html>