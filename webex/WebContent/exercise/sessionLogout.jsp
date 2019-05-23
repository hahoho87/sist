<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션 속성 삭제
	session.removeAttribute("name");
	session.removeAttribute("bloodType");
	//세션 삭제
	session.invalidate();
	
%>
	<jsp:forward page="sessionData.jsp"></jsp:forward>
