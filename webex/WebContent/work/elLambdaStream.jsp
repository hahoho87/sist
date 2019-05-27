<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, webex.vo.MyBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elLambdaStream.jsp</title>
</head>
<body>
	<h3>EL lambda and stream</h3>
	${ list = [ 11, 2, 13, 4, 5];'' }
	list 	= [ 11, 2, 13, 4, 5]			<br>
	합계 		= ${ list.stream().sum() }	<br>
	짝수의 합계 = ${ list.stream()
				      .filter( x -> x % 2 == 0)
					  .sum() }<br>
	3개까지 오름차순 정렬 = ${ list.stream()
					   		 .sorted()
					   		 .limit(3)
					         .toList() }<br>
	오름차순 정렬 = ${ list.stream()
					   .sorted()
					   .toList() }<br>
	내림차순 정렬 = 	${ list.stream()
					   .sorted( (a, b) -> a < b ? 1 : -1 )
					   .toList() }	<br>			   
	<br><br>
<%
	//MyBeans를 저장하는 List 객체 beans 생성
	List<MyBeans> beans = Arrays.asList(
		new MyBeans("Korea", "Seoul", "Kim"),
		new MyBeans("China", "Beijing", "Wang"),
		new MyBeans("Japan", "Tokyo", "Mori")
	);
	request.setAttribute("beans", beans);
%>
	toList( ) : ${ beansList = beans.stream()
						            .map( bean -> bean.city)
						            .toList();''}<br>
	${ beansList }<br>
	${ beansList[0] }<br>
	${ beansList[1] }<br>
	${ beansList[2] }<br><br>

	toArray( ) : ${ beansArray = beans.stream()
						             .map( bean -> bean.city)
						             .toArray();''}<br>
	${ beansArray }<br>
	${ beansArray[0] }<br>
	${ beansArray[1] }<br>
	${ beansArray[2] }<br>
	<br>
	city 개수 = ${ beans.stream().count() }<br>
	
	city 정렬 전 = ${ beans.stream()
						.map( bean -> bean.city)
						.toList() }<br>
	city 오름차순 정렬 = ${ beans.stream()
							 .sorted( (a, b) -> a.city.compareTo(b.city))
							 .map( bean -> bean.city)
						     .toList() }<br>
	city 내림차순 정렬 = ${ beans.stream()
							 .sorted( (a, b) -> b.city.compareTo(a.city))
							 .map( bean -> bean.city)
						     .toList() }<br>
	
	<br><br>
	${ map = { 'a':5, 'b':10, 'c':15 };'' }
	map = { 'a':5, 'b':10, 'c':15 }		<br>
	합계 = ${ map.entrySet()
			    .stream()
			    .map(entry -> entry.value)
			    .toList()
				.stream()
				.sum() }				<br>
	홀수의 합계 = ${ map.entrySet()
			    .stream()
			    .map(entry -> entry.value)
			    .toList()
				.stream()
				.filter( x -> x % 2 != 0)
				.sum() }
	
	
	<hr>
	${ result = (a, b) -> a > b ? true : false ; '' }
	1 &gt; 2 : ${ result(1, 2) }
	
	<br>
<%--3 &gt; 4 : ${ ( (c, d) -> c > d ? true : false )(3, 4) } --%>
	
	<br>
	${ factorial = (n) -> n == 1 ? 1 : n * factorial(n-1) ;''}
	factorial 3 : ${ factorial(3) }
	
	<br>
	${ factorial = n -> n == 1 ? 1 : n * factorial(n-1) ;''}
	factorial 5 : ${ factorial(5) }
</body>
</html>




















