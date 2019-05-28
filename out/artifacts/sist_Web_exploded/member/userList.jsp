<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, webex.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList.jsp</title>
<style>
table { width: 500px; margin-bottom: 5px; }
table, th, td{ border: 1px solid gray; border-collapse: collapse; padding: 3px; }
#table:hover {
	color:red;
}
</style>
</head>
<body>
	<h3>USER LIST PAGE
		<jsp:include page="../include/loginChk.jsp"/>
	</h3>
	<jsp:include page="../include/adminChk.jsp"/>

	<table>
	<tr><th>No.</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th></tr>
	<%
	
		List<MemberVO> memberList 
			= (List<MemberVO>)request.getAttribute("memberList");
		int i=1;
		for (MemberVO mvo : memberList) {
	%>	<tr id="table">
			<td><%=i++ %></td>
			<td><%=mvo.getUserId() %></td>
			<td><%=mvo.getUserNm() %></td>
			<td><%=mvo.getEmail1() %>@<%=mvo.getEmail2() %></td>
		</tr>
	<%	}	%>
	</table>
	<button type="button">이전으로</button>
</body>
</html>





