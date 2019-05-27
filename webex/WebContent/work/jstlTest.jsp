<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlTest.jsp</title>
</head>
<body>
	<h3>Java Standard Tag Library</h3>
	<ul><li>IF<br>
			<c:set var="x" value="7"/>
			<c:set var="y" value="8"/>
			<c:out value="${ x > y ? 'big' : 'small' }"/>
			<br>
			<c:if test="${x < y }">
				x is small
			</c:if>
			<br>
			<c:if test="${empty sid }">
				로그인 후 이용해주세요.
			</c:if>
			<hr>
			<!-- 세션 객체의 sid 속성에 값을 abc로 저장 -->
			<% session.setAttribute("sid", "abc"); %>
			<!-- sid가 널이면 '로그인 후 이용해주세요'출력
				 sid가 널이 아닌 경우 
				 sid가 admin이면 관리자 페이지 출력
				 admin이 아니면 사용자 페이지 출력 -->
			<c:choose>
				<c:when test="${empty sid }">
					로그인 후 이용해 주세요.
				</c:when>
				<c:when test="${sid eq 'admin' }">
					관리자 페이지
				</c:when>
				<c:otherwise>
					사용자 페이지
				</c:otherwise>
			</c:choose>
		</li>
		<li>변수 설정 및 사용			<br>
			<c:set var="x" value="7"/>
			<c:set var="y" value="8"/>
			x = ${ x }<br>
			y = ${ y }<br>
			x + y = <c:out value="${ x + y }"/>
			<br><br>
			<c:remove var="x"/>
			<c:remove var="y"/>
			x = ${ x }<br>
			y = ${ y }<br>
			x + y = <c:out value="${ x + y }"/>
			
			<br><br>
			<!-- HashMap 객체 map을 액션태그로 생성 -->
			<jsp:useBean id="map" class="java.util.HashMap"/>
			<c:set target="${map }" property="key" value="map's value"/>
			${map.key }
		</li>
		<li>Deferred Expression $ vs. #<br>
			<c:set var="m" value="${map }"/>
			<c:set var="bgColor" value="${m.bgColor }"/>
			BEFORE bgColor : ${bgColor }<br>
			<c:set target="${m }" property="bgColor" value="blue"/>
			AFTER bgColor : ${bgColor }<br>
			<br>
			<c:set var="fontColor" value="#{m.fontColor }"/>
			BEFORE fontColor : ${fontColor }<br>
			<c:set target="${m }" property="fontColor" value="red"/>
			AFTER fontColor : ${fontColor }<br>
		</li></ul>
	
	
	<hr>
	<c:out value="Hello JSTL!~"/>	 <br>
	\${data } : ${data }			 <br>
	c:out = <c:out value="${data }" default="no data"/><br><hr>
	
	<% request.setAttribute("data", "<em>12345</em>"); %>
	\${data } : ${data }			 <br>
	c:out = <c:out value="${data }" default="no data" /><br>
	c:out = <c:out value="${data }" escapeXml="true" /><br>
	c:out = <c:out value="${data }" escapeXml="false" /><br>
	
</body>
</html>















