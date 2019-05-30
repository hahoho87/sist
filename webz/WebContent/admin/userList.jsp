<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList.jsp</title>
<link rel="stylesheet" href="/webz/style/style.css">
</head>
<body>
	<h3>USER LIST PAGE</h3>
	<c:if test="${ !empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<c:choose>
		<c:when test="${ empty memberList }">
			등록된 회원이 없거나 회원 목록을 가져오지 못했습니다.
		</c:when>
		<c:otherwise>
			<table id="listTable">
				<tr>
					<th>No.</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
				</tr>
				<c:forEach items="${ memberList }" var="mvo" varStatus="i">
					<c:url var="link" value="Main.do">
						<c:param name="userId" value="${ mvo.userId }" />
						<c:param name="flag" value="s" />
					</c:url>
					<tr>
						<td>${ i.count }</td>
						<td>
							<a href="${ link }">${ mvo.userId }</a>
						</td>
						<td>${ mvo.userNm }</td>
						<td>${ mvo.email1 }@${ mvo.email2 }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>