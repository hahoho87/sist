<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.jsp</title>
</head>
<body>
	<h3>RECEIVED DATA</h3>

	id :
	<%=request.getParameter("userId")%><br> name :
	<%
		out.print(request.getParameter("usernm"));
	%><br> hobby :
	<%
		String[] hobbies = request.getParameterValues("hobby");
		if (hobbies != null) {
			for (String hobby : hobbies) {
				out.print(hobby + " ");
			}
		}
		//id가 admin이면 /member/adminMain.jsp로 redirect
//		String id = request.getParameter("userId");
//		if (id.equals("admin")) {
//			response.sendRedirect("../member/adminMain.jsp");
//		} else {
			//그렇지 않으면 //member/main.jsp로 redirect
//			response.sendRedirect("../member/main.jsp");
//		} 
	%>
	<hr>

	<h3>request</h3>
	<ul>
		<li>Server Name : <%=request.getServerName()%></li>
		<li>Server Address : <%=request.getLocalAddr()%></li>
		<li>Server Port : <%=request.getServerPort()%></li>
		<li>Client Port : <%=request.getRemotePort()%></li>
		<li>context path : <%=request.getContextPath() %></li>
	</ul>

	<h3>request header info</h3>
	<%
		Enumeration<String> result = request.getHeaderNames();
		while (result.hasMoreElements()) {
			String headerName = result.nextElement();
			out.print("<br>[" + headerName + "] " + request.getHeader(headerName));
		}
	%>



</body>
</html>













