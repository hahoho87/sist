<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elObject.jsp</title>
</head>
<body>
	<!-- 요청 객체의 data 속성에 REQUEST 저장
    세션 객체의 data 속성에 SESSION 저장
    어플리케이션 객체의 data 속성에 APPLICATION 저장
    이름은 data, 값은 COOKIE인 쿠키 객체를 생성하여
    응답 객체에 저장
    입력 폼의 이동 페이지는 elObjecView.jsp로 지정-->
	<%
		request.setAttribute("data", "REQUEST");
		session.setAttribute("data", "SESSION");
		application.setAttribute("data", "APPLICATION");
		Cookie cookie = new Cookie("data", "COOKIE");
		response.addCookie(cookie);
	%>

	<jsp:forward page="elObjecView.jsp">
		<jsp:param value="PARAM" name="data" />
		<jsp:param value="DOG" name="animal" />
		<jsp:param value="CAT" name="animal" />
		<jsp:param value="BAT" name="animal" />
	</jsp:forward>


	<!--  <form action="elObjecView.jsp">
		<input type="hidden" name="data" value="PARAM"> 
		<input type="text" name="animal" value="DOG"> <br> 
		<input type="text" name="animal" value="CAT"> <br> 
		<input type="text" name="animal" value="BAT"> 
		<input type="submit" value="submit">
	</form>		-->

	<h3>EL with List and Map</h3>
	${ list = [3, 6, 9];''} ${ list[0]}
	<br>
	<!-- map은 중괄호로 넣어야 한다. -->
	${ map = { 'a' : 'Seoul', 'b' : 'Busan', 'c' : 'Jeju' };'' }
	<br> ${ map.c }

	<%
		String starArr[] = { "Sun", "Moon", "Earth" };
		List<String> starList = Arrays.asList("해", "달", "별");
		HashMap<String, String> starMap = new HashMap<String, String>();
		starMap.put("one", "스타트랙");
		starMap.put("two", "스타워즈");
		starMap.put("three", "지구탈출");

		//요청객체의 속성에 위 객체 3개 저장
		request.setAttribute("starArr", starArr);
		request.setAttribute("starList", starList);
		request.setAttribute("starMap", starMap);
	%>
	<jsp:useBean id="actionBean" class="webex.vo.MyBeans"></jsp:useBean>
	<!-- useBean with 직접 값 지정 -->
	<jsp:setProperty property="country" value="China" name="actionBean" />
	<jsp:setProperty property="city" value="Beijing" name="actionBean" />
	<jsp:setProperty property="name" value="Wang" name="actionBean" />
	<h3>EL with Object</h3>
	<ul>
		<li>배역 객체 출력 <br> ${ starArr[0] } <br> ${ starArr[1] } <br> ${ starArr[2] } <br>
		</li>
		<li>list <br> ${ starList[0] } <br> ${ starList[1] } <br> ${ starList[2] } <br>
		</li>
		<li>Map 출력 <br> ${ starMap["one"] } <br> ${ starMap['two'] } <br> ${ starMap.three } <br>
		</li>
		<li>JavaBeans <br> ${ actionBean["country"] } <br> ${ actionBean['city'] } <br> ${ actionBean.name }<br>
		</li>
	</ul>
</body>
</html>