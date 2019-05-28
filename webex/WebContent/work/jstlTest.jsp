<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlTest.jsp</title>
</head>
<body>
	<h3>Java Standard Tag Library</h3>
	<ul><li>catch<br>
			<c:catch var="e">
				<c:set var="num1" value="O"/>
				<c:out value="${ num1 / 3 }"/>
			</c:catch>	
			<!-- e가 널이 아니면 e.massage 출력 -->
			<c:out value="${ e }"/>
			<c:if test="${ empty e }">
			<c:out value="${ e.massage }"/>
			</c:if>
		</li>
		<li>import<br>
			<c:import url="jstlResult.jsp">
				<c:param name="code" value="000"/>
				<c:param name="id" value="none"/>
			</c:import>
		</li>
		<li>redirect<br>
<%-- 		<c:redirect url="jstlResult.jsp">
				<c:param name="code3" value="789"/>
				<c:param name="id3" value="guest"/>
			</c:redirect> --%>
		</li>
		<li>url<br>
			<c:url var="result" value="jstlResult.jsp">
				<c:param name="code2" value="456"/>
				<c:param name="id2" value="member"/>
			</c:url>
			<a href="${ result }">jstl result page</a><br>
			<a href="jstlResult.jsp?code=123&id=admin">jstlResult</a>
		</li>
		<li>FOR TOKENS<br>
			<c:forTokens items="12:30, SERVER BACKUP, meeting" delims="," var="s">
				${ s } | 
			</c:forTokens>
		</li>
		<li>FOR EACH<br>
		<!-- colorList의 색을 글자의 색으로 지정하여 화면으로 출력 -->
	<% 
		String[] colors = {"red", "green", "blue"};
		pageContext.setAttribute("colors", colors);
		
		//무지개 색깔 7가지를 갖는 List 객체 colorList 생성
		//요청 객체의 colorList 속성에  colorList 지정
		List<String> colorList = Arrays.asList("red", "orange", "yellow", "green", "blue", "navy", "purple");
		request.setAttribute("colorList", colorList);
	%>
			<c:forEach var="colorList" items="${ colorList }" varStatus="i">
				<span style="color:${colorList }">${ i.index } | ${ i.count}. 이 글자의 색상은 ${ colorList }</span><br>
			</c:forEach>
			<hr>
			<c:forEach var="i" begin="1" end="10" step="2">
				${ i }. hello<br>
			</c:forEach>
			<hr>
			<c:forEach var="c" items="${ colors }">
				${ c }
			</c:forEach>	
			<hr>
		</li>
	
		<li>IF<br>
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















