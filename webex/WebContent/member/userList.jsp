<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, webex.vo.MemberVO, webex.dao.MemberDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList.jsp</title>
<style>
table {
	width: 500px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid gray;
	border-collapse: collapse;
	padding: 3px;
}

#list:hover {
	background: lightgray;
}
</style>
</head>

<body>
	<c:if test="${ !empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<h3>
		USER LIST PAGE
		<jsp:include page="../include/loginChk.jsp" />
	</h3>
		<jsp:include page="../include/adminChk.jsp" />

	<!-- EL & jstl 사용 -->	
	<c:choose>
		<c:when test="${ empty memberList }">
			등록된 회원이 없거나 회원 목록을 가져오지 못했습니다.
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>No.</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
				</tr>
				<c:forEach items="${ memberList }" var="mvo" varStatus="i">
				<c:url var="link" value="Member.do">
					<c:param name="userId" value="${ mvo.userId }"/>
					<c:param name="flag" value="s"/>
				</c:url>
				<tr><td>${ i.count }</td>
					<td><a href="${ link }">${ mvo.userId }</a></td>
					<td>${ mvo.userNm }</td>
					<td>${ mvo.email1 }@${ mvo.email2 }</td></tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

	<!-- scriptlet & 표현식 사용 -->
	<%-- <table>
	<tr><th>No.</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th></tr>
	<%
		List<MemberVO> memberList 
			= (List<MemberVO>)request.getAttribute("memberList");
	
		int i=1;
		for (MemberVO mvo : memberList) {
		request.setAttribute("userId", mvo.getUserId());	
	%>	<c:url var="link" value="Member.do">
			<c:param name="userId" value="${ userId }"/>
			<c:param name="flag" value="s"/>
		</c:url>	
		<tr>
			<td><%=i++ %></td>
			<td><a href="${ link }">${ userId }</a></td>
			<td><%=mvo.getUserNm() %></td>
			<td><%=mvo.getEmail1() %>@<%=mvo.getEmail2() %></td>
		</tr>
	<%	}	%>
	</table> --%>
	<button type="button" onclick="history.back()">이전으로</button>

</body>
</html>





