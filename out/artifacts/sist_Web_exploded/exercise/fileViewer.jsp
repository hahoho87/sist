<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileViewer.jsp</title>
</head>
<body>
	<h3>JSP FILE VIEWER</h3>
	file name :
	<%=request.getParameter("filename")%><br> file content :
	<%
		String filename = request.getParameter("filename");
		String path = application.getInitParameter("filepath");
		String realPath = application.getRealPath(path);
		String content = "";
		BufferedReader br = new BufferedReader(new FileReader(realPath + filename));

		try {
			while ((content = br.readLine()) != null) {
				out.print(content + "<br>");
			}
		} catch (FileNotFoundException e) {
			out.print("해당 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			out.print("파일을 읽을 수 없습니다.");
		}
		
		
		br.close();
		
	%>
</body>
</html>