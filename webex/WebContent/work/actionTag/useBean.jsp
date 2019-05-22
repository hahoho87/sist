<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="webex.vo.MyBeans, webex.dao.MyBeansDAO"%>
<%
	//MyBeans 클래스의 객체 bean 생성
	//country는 Korea
	//city는 Seoul
	//name은 Lee로 저장

	MyBeans beans = new MyBeans();

	beans.setCountry("KOREA");
	beans.setCity("Seoul");
	beans.setName("Lee");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBeans.jsp</title>
</head>
<body>
	<h3>ACTION TAG : useBean</h3>
	<jsp:useBean id="actionBean" class="webex.vo.MyBeans"></jsp:useBean>
	<!-- useBean with 직접 값 지정 -->
	<jsp:setProperty property="country" value="China" name="actionBean"/>
	<jsp:setProperty property="city" value="Beijing" name="actionBean"/>
	<jsp:setProperty property="name" value="Wang" name="actionBean"/>
	<br>
	<!-- useBean with 요청 객체의 parameter 이용 값 지정 -->
	<jsp:useBean id="actionBean2" class="webex.vo.MyBeans"></jsp:useBean>
	<jsp:setProperty property="country" name="actionBean2"/>
	<jsp:setProperty property="city" name="actionBean2"/>
	<jsp:setProperty property="name" name="actionBean2"/>
	<br>
	<!-- useBean with 요청 객체의 parameter 이용 값 지정 -->
	<jsp:useBean id="actionBean3" class="webex.vo.MyBeans"></jsp:useBean>
	<jsp:setProperty property="*" name="actionBean3"/>
	<%
		/*
		<jsp:useBean id="actionBean3" class="webex.vo.MyBeans"></jsp:useBean>
		이 코드는
		
		import = webex.dao.MyBeansDAO; 
		MyBeans actionBean3 = new MyBeans();
		와 같은 코드		
		*/
	%>
	
	<br>
	<jsp:useBean id="mDao" class="webex.dao.MyBeansDAO"></jsp:useBean>
	<%
		//myBeansDAO의 insert() 호출하고
		//결과를 result 변수에 저장하고
		//true이면 "db 쿼리 성공" 출력 실패하면 "db 쿼리 실패"
		//MyBeansDAO mDao = new MyBeansDAO();	//useBean으로 이미 생성
		Boolean result = mDao.insert(actionBean3);
		
		if (result) {
			out.print("DB 쿼리 성공");
		} else {
			out.print("DB 쿼리 실패");
		}
		
	%>
	
	
	<ul>
		<li>Country : <jsp:getProperty property="country" name="actionBean3"/></li>
		<li>City :<jsp:getProperty property="city" name="actionBean3"/></li>
		<li>Name : <jsp:getProperty property="name" name="actionBean3"/></li>
	</ul>
	<ul>
		<li>Country : <jsp:getProperty property="country" name="actionBean2"/></li>
		<li>City :<jsp:getProperty property="city" name="actionBean2"/></li>
		<li>Name : <jsp:getProperty property="name" name="actionBean2"/></li>
	</ul>
	
	<ul>
		<li>Country : <%=beans.getCountry()%></li>
		<li>City : <%=beans.getCity()%></li>
		<li>Name : <%=beans.getName()%></li>
	</ul>
	
	<ul>
		<li>Country : <jsp:getProperty property="country" name="actionBean"/></li>
		<li>City :<jsp:getProperty property="city" name="actionBean"/></li>
		<li>Name : <jsp:getProperty property="name" name="actionBean"/></li>
	</ul>	
	
	<%
	actionBean.setCountry("Japan");
	actionBean.setCity("Tokyo");
	actionBean.setName("Lie");
	%>
	<ul>
		<li>Country : <%=actionBean.getCountry()%></li>
		<li>City : <%=actionBean.getCity()%></li>
		<li>Name : <%=actionBean.getName()%></li>
	</ul>
	
	<ul>
		<li>Country : <%=beans.getCountry()%></li>
		<li>City : <%=beans.getCity()%></li>
		<li>Name : <%=beans.getName()%></li>
	</ul>

</body>
</html>