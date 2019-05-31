<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${ !empty sid }">
<button type="button" onclick="logout()" class="buttons">로그아웃</button>
<script>
	function logout() {
		var result = confirm("로그아웃하시겠습니까?");
		if (result == true) {
			location.href='/webz/Main.do?flag=lo';   
		}
	}
</script>
</c:if>
