<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="webex.vo.MyBeans"%>
<%
	MyBeans bean = new MyBeans();	//MyBeans 클래스의 객체 bean 생성
	bean.setCountry("Korea");		//country는 Korea, 
	bean.setCity("Seoul");			//city는 Seoul, 
	bean.setName("Lee");			//name은 Lee로 저장
	
	request.setAttribute("bean", bean);
	request.setAttribute("code", "1234");
%>  
<!DOCTYPE html><html><head><meta charset="UTF-8"><title>elTest.jsp</title></head>
<body>
	<h3>EL 변수 생성</h3>
	1 : a = 1 ; b = 2 ; c = a + b  <br>
	2 : ${ a = 1; b = 2 ; c = a + b } <br>
	3 : ${ a = 1; b = 2 ; c = a + b ;''} <br>
	4 : a = ${ a }<br>
	5 : b = ${ b }<br>
	6 : c = ${ c }

	
	<h3>EL 연산자</h3>
	\${ empty sessionScope.sid ? 'guest' : 'member' }<br>
	${ empty sessionScope.sid ? 'guest' : 'member' }<br>
	${ !empty sid ? 'guest2' : 'member2' }<br>
	
	<!-- session의 sid 속성에 admin 저장 -->
	<%	session.setAttribute("sid", "admin"); %>
	${ empty sessionScope.sid ? 'guest' : 'member' }<br>
	${ !empty sid ? 'guest2' : 'member2' }<br>
	
	param.x = ${param.x }<br>
	param.y = ${param.y }<br>
	
	x와 y는 모두 양수 ? ${ (param.x > 0) && (param.y > 0) } <br>
	x와 y는 모두 양수 ? ${ (param.x gt 0) and (param.y gt 0) } <br>
	
	x 나누기 y의 몫 		= ${ param.x / param.y }<br>
	x 나누기 y의 나머지 	= ${ param.x % param.y }<br>
	x 나누기 y의 몫 		= ${ param.x div param.y }<br>
	x 나누기 y의 나머지 	= ${ param.x mod param.y }<br>
	
	x와 y는 같다?		= ${ param.x eq param.y ? "예" : "아니오" }

	<h3>EL DATA TYPE</h3>
	int 	: ${ 12345 }<br>
	double 	: ${ 123.456 } <br>
	true 	: ${ true } <br>
	false 	: ${ false } <br>
	String 	: ${ "Hello" } <br>
	char	: ${ 'hello' } <br>
	null	: ${ null } <br>
	
	code 	: ${ code } <br>
	param.code : ${ param.code }<br>
	param["code"] : ${ param["code"] }<br>
	param['code'] : ${ param['code'] }<br>
	<br>
	
<%-- 	1 + 2 		= ${ 1 + 2 }	<br>
	1 + null 	= ${ 1 + null }	<br>
	"일" + 2 	= ${ "일" + 2 }	<br>

	"1" + 2 	= ${ "1" + 2 }	<br>
	"1" + "2" 	= ${ "1" + "2" }<br>
	
	"1" += 2 	= ${ "1" += 2 }	<br>
	"1" += "2" 	= ${ "1" += "2" }	<br> --%>
	
	header.host = ${ header.host }
	
	<jsp:useBean id="actionBean" class="webex.vo.MyBeans"/>
	<jsp:setProperty property="country" name="actionBean" value="China"/>
	<jsp:setProperty property="city"    name="actionBean" value="Shanghai"/>	
	<jsp:setProperty property="name"    name="actionBean" value="Wang"/>
	
	<h3>Expression Language</h3>
	${ actionBean.test('hi')} <br>
	${ actionBean} <br>
	${ Math.random() }
	
	<ol><li>스크립틀릿<br>
			country : <%out.print(bean.getCountry()); %> <br>
			city : 	  <%out.print(bean.getCity()); %> <br>
			name :    <%out.print(bean.getName()); %> </li>
		<li>표현식<br>
			country : <%=bean.getCountry() %><br>
			city :    <%=bean.getCity() %><br>
			name :    <%=bean.getName() %></li>
		<li>액션태그<br>
			country : <jsp:getProperty property="country" name="actionBean"/><br>
			city : 	  <jsp:getProperty property="city" name="actionBean"/><br>
			name :    <jsp:getProperty property="name" name="actionBean"/></li>
		<li>EL<br>
			country : ${ bean.country }<br>
			city : 	  ${ bean.city }<br>
			name : 	  ${ bean.name }</li></ol>
	
</body>
</html>









