<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
		import="webex.vo.MyBeans, webex.dao.MyBeansDAO"%>
<%
	//MyBeans 클래스의 객체 bean 생성
	//country는 Korea
	//city는 Seoul
	//name은 Lee로 저장

	MyBeans beans = new MyBeans();

	beans.setCountry("KOREA");
	beans.setCity("Seoul");
	beans.setName("Lee");
	
	request.setAttribute("beans", beans);
	request.setAttribute("code", "1234");
	
%>
	<jsp:useBean id="actionBean" class="webex.vo.MyBeans"/>
	<!-- useBean with 직접 값 지정 -->
	<jsp:setProperty property="country" value="China" name="actionBean"/>
	<jsp:setProperty property="city" value="Beijing" name="actionBean"/>
	<jsp:setProperty property="name" value="Wang" name="actionBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest.jsp</title>
</head>
<body>
	<h3>EL 번수 생성</h3>
	1 : a = 1; b = 2; c = a + b <br>
	2 : ${ a = 1 ; b = 2 ; c = a + b } <br>
	3 : ${ a = 1 ; b = 2 ; c = a + b ; ''} <br>
	4 : a = ${ a } <br>
	5 : b = ${ b } <br>
	6 : c = ${ c } <br>

    <h3>EL 연산자</h3>
    x = ${ param.x }<br>
    y = ${ param.y }<br>
    x와 y는 모두 양수 ? ${ param.x > 0 && param.y > 0 } <br>
    x와 y는 모두 양수 ? ${ (param.x gt 0) and (param.y gt 0) } <br>
    x 나누기 y의 몫 = ${ param.x / param.y }<br>
    x 나누기 y의 몫 = ${ param.x div param.y }<br>
    x 나누기 y의 나머지 = ${ param.x % param.y }<br>
    x 나누기 y의 나머지 = ${ param.x mod param.y }<br><br>
    
    x와 y는 같다 ? = ${ param.x == param.y ? "예" : "아니오" }<br><br>
    
    ${ empty sessionScope.sid ? "guest" : "member" } <br>
    ${ !empty sid ? "guest2" : "member2" } <br>
    
    <!-- session의 sid 속성에 admin 저장 -->
    <% session.setAttribute("sid", "admin"); %>
    
    <!-- 특수문자를 쓰고 싶을 땐 앞에 역슬래쉬를 붙힌다 (ex. \$ ) -->
    

	<h3>EL DATA TYPE</h3>
	int : ${ 12345 } <br>
	double : ${ 123.456 } <br>
	true : ${ true } <br>
	false : ${ false } <br>
	String : ${ "Hello" } <br>
	char : ${ 'hello' } <br> 
	null : ${ null } <br>
	code : ${ code } <br>
	<!-- qeury string으로 파라미터 값 전송 (주소 뒤에 ?code=5678 -->
	param.code : ${ param.code } <br>
	param."code" : ${ param.code } <br>
	param.'code' : ${ param.code } <br><br>
    1 + 2 : ${ 1 + 2 } <br>
    1 + null : ${ 1 + null } <br>
    "1" + 2 = ${ "1" + 2 } <br>
    "1" + "2" = ${ "1" + "2" } <br>
<%--    "일" + 2 = ${ "일" + 2 } <br>  에러--%>
    "1" += 2 = ${ "1" += 2 } <br>
    "1" += "2" = ${ "1" += "2" } <br><br>
    
    x = ${ param.x }<br>
    y = ${ param.y }<br>
    
	<h3>Expression Language</h3>
	${ actionBean.test('Hi') } <br>
	${ actionBean } <br>
	${ Math.random() } <br>
	
	<ol>
		<li>Scriptlet <br> 
		country : <% out.print(beans.getCountry()); %><br> 
		city : <% out.print(beans.getCity()); %><br> 
		name : <% out.print(beans.getName()); %><br><br>
		
		
		<li>Expression <br> 
		country : <%= beans.getCountry() %><br> 
		city : <%= beans.getCity() %><br> 
		name : <%= beans.getName() %><br><br></li>
		
		<li>Action Tag<br> 
		Country : <jsp:getProperty property="country" name="actionBean"/><br>
		City :<jsp:getProperty property="city" name="actionBean"/><br>
		Name : <jsp:getProperty property="name" name="actionBean"/><br> </li>
		
		<li>EL <br> 
		country : ${ beans.country }<br> 
		city : ${ beans.city }<br> 
		name : ${ beans.name }<br><br></li>
	</ol>
</body>
</html>