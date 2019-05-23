<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session.jsp</title>
</head>
<body>
	<h3>session</h3>
	
	<% 
		//세선이 새로 만들어지면 경고창으로 알림
		boolean result = session.isNew();
		if (result == true) {
			out.print("<script>alert('NEW SESSION!!');</script>");
		}
	%>
	<p>
		세션 ID : <%=session.getId()%>]=<br> 
		세션 생성 시간 : <%=session.getCreationTime()%><br> 
		세션 생성 시간 : <%=new Date(session.getCreationTime())%><br> 
		세션 생성 시간 : <%=new Date(session.getCreationTime()).toLocaleString()%><br>
		<!-- 초 단위이기 때문에 60으로 나눠준다 -->
		세션 유효 시간 : <%=session.getMaxInactiveInterval() / 60%>분<br><br>
		세션 유효 시간 변경 : 1분 <% session.setMaxInactiveInterval(60); %><br>
		세션 유효 시간 : <%=session.getMaxInactiveInterval() / 60%>분<br>
		최종 세션 접근 시간 : <%=new Date(session.getLastAccessedTime()).toLocaleString() %><br><br>
		
		세션의 속성에 값 저장 : 이름 - key, 값 - code <br>
		<% session.setAttribute("key", "code"); %>
		세선의 key 속성 출력 : 이름 - key , 값 - <%= session.getAttribute("key") %><br>
		세션의 key 속성 삭제	 <%session.removeAttribute("key"); %><br>
		세선의 key 속성 출력 : 이름 - key , 값 - <%= session.getAttribute("key") %><br>
		세션 무효화 	<% session.invalidate(); %><br>
	</p>
</body>
</html>