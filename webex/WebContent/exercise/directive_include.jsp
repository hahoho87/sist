<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directive_include.jsp</title>
<style>
body { margin: -20px auto; width:800px; }
header { background: yellow; width:100%; height:100px; 	
		 padding:0px 10px;  box-sizing: border-box; }
nav { background:navy; height:30px; }
nav ul { list-style: none; margin: auto; text-align: center; }
nav ul li { width: 100px; 
			background-color: navy; 
	 		color:white;
	 		text-align: center; 
	 		font-weight: bold; 
	 		padding: 4px; 
	 		display: inline-block; }
li:hover { 	background-color: white; 
	 		color:navy;
	 		border: 1px solid navy; 
	 		padding: 3px; } 
section { width:80%; height:300px;
		  background:orange; 
		  float: left;  
		  padding: 0px 20px; 
		  box-sizing: border-box; }	 		
aside { width:20%; height:300px; 
		background:cyan; 
		float: right; 
	    padding: 0px 20px;  
	    box-sizing: border-box; }
footer { clear:both;
		 width:100%; height:50px;
		 background:gray;
		 text-align:center; 
		 padding-top: 5px; 
		  }		
h1 { text-shadow: 3px 3px 3px red; }		  
</style>
</head>
<body>
<header>
	<H1>HEADER</H1>
</header>
<nav>
	<ul>
		<li>HOME</li>
		<li>Notice</li>
		<li>Board</li>
		<li>Q &amp; A</li>
		<li>FAQ</li>
	</ul>
</nav>
<section>
	<%@ include file="include_section.jsp" %>
</section>
<aside>
	<%@ include file="include_aside.jsp" %>
</aside>
<footer>
Copyright
<address>서울시 마포구</address>
</footer>
</body>
</html>





