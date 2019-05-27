<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elOptional.jsp</title>
</head>
<body>
	<h3>EL OPTIONAL</h3>
	${ list = [1, 3, 5]; '' }
	${ emptyList = [ ];	'' }
	
	anyMatch() : ${ list.stream().anyMatch( x -> x > 3).get() }<br>
	anyMatch() : ${ list.stream().anyMatch( x -> x > 5).get() }<br><br>
	
	allMatch() : ${ list.stream().allMatch( x -> x > 3).get() }<br>
	allMatch() : ${ list.stream().allMatch( x -> x > 0).get() }<br><br>
	
	noneMatch() : ${ list.stream().noneMatch( x -> x > 0).get() }<br>
	noneMatch() : ${ list.stream().noneMatch( x -> x > 5).get() }<br><br>
	
	
	<hr>
	list = [1, 3, 5] <br>
	emptyList = [ ] <br>
	1, 3, 5 의 합계 = 		${ list.stream().sum() }<br>
	1, 3, 5 의 평균 = 		${ list.stream().average().get() }<br>
	1, 3, 5 의 최소값 = 	${ list.stream().max().get() }<br>
	1, 3, 5 의 최대값 = 	${ list.stream().min().get() }<br>
	
	<hr>
	최대값 = ${ list.stream().max().get() } <br>
	<%-- 최대값 = ${ emptyList.stream().max().get() } <br> --%>
	최대값 = ${ emptyList.stream().max().orElse('값 없음') } <br>
	
	${ maximum = 'none'; ''}
	${ list.stream().max().ifPresent( x-> (maximum = x) ) } <br>
	maximum : ${ maximum }<br>
	${ emptyList.stream().max().ifPresent( x-> (maximum = x) ) } <br>
	maximum : ${ maximum }<br>
	
	<%-- ${ emptyList.stream().max().ifPresent( x-> maximum = x ) } <br>
	maximum : ${ maximum }<br> 괄호가 없으면 -> 식이 먼저 진행되므로 오류--%>
	
</body>
</html>