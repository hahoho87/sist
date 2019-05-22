<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actionTag_include.jsp</title>
<style>
body {
	margin: -20px auto;
	width: 800px;
}

header {
	background: lightgray;
	width: 100%;
	height: 100px;
	padding: 0px 10px;
	box-sizing: border-box;
}

nav {
	background: navy;
	height: 30px;
}

nav ul {
	list-style: none;
	margin: auto;
	text-align: center;
}

nav ul li {
	width: 100px;
	background-color: navy;
	color: white;
	text-align: center;
	font-weight: bold;
	padding: 4px;
	display: inline-block;
}

li:hover {
	background-color: white;
	color: navy;
	border: 1px solid navy;
	padding: 3px;
}

section {
	width: 80%;
	height: 300px;
	background: lightgreen;
	float: left;
	padding: 0px 20px;
	box-sizing: border-box;
}

aside {
	width: 20%;
	height: 300px;
	background: skyblue;
	float: right;
	padding: 0px 20px;
	box-sizing: border-box;
}

footer {
	clear: both;
	width: 100%;
	height: 50px;
	background: pink;
	text-align: center;
	padding-top: 5px;
}

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
		<jsp:include page="include_section.jsp"></jsp:include>
	</section>
	<aside>
		<jsp:include page="include_aside.jsp"></jsp:include>
	</aside>
	<footer>
		Copyright
		<address>서울시 마포구</address>
	</footer>
</body>
</html>





