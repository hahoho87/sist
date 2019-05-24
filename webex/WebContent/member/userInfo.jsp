<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import=""%>
<%
	//회원 전용 페이지
	//요청 객체의 mvo 특성의 값을 넘겨받아서
	//null이 아니면 
	//화면에 회원 정보 출력

	if (request.getAttribute("mvo") != null) {

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo.jsp</title>
</head>
<body>
	<h3>USER INFO PAGE</h3>
	<jsp:include page="../include/loginChk.jsp"></jsp:include>
	<jsp:useBean id="mvo" class="webex.vo.MemberVO" scope="request" />

	<%
		//회원 전용 페이지!!
		//요청 객체의 mvo 속성의 값을 넘겨받아서 null이 아니면 화면에 회원 정보 출력
		if (mvo != null) {
	%>
	아이디 :	<jsp:getProperty property="userId" name="mvo"/>
	이름 :		<jsp:getProperty property="userNm" name="mvo"/><br> 
	이메일 : 	<jsp:getProperty property="email1" name="mvo"/>@
			 	<jsp:getProperty property="email2" name="mvo"/><br> 
	가입일자 :  <jsp:getProperty property="regDate" name="mvo"/><br> 
	생년월일: 	<% out.print(mvo.getBirthDate()); %><br> 
	사진 : 		<%=mvo.getPhoto() %><br>
	<hr />

	<%
		}
	%>
						</body>
</html>