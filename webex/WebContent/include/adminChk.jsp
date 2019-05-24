<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 세션의 sid 속성의 값이  admin이 아니면 
	 관리자 전용 페이지 알림 메시지 출력 후
	 로그인 페이지로 이동 -->
<%
	if (session.getAttribute("sid") != null && !session.getAttribute("sid").equals("admin")) {
%>
<script>
	alert("관리자 전용 페이지입니다.\n관리자로 로그인 후 이용해 주세요.");
	location.replace('/webex/member/join03.jsp');
</script>
<%
	}
%>
