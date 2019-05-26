<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>open.html</title>
<script>
	function popupOpen() {
		window.open("popup.jsp", "_blank",
				"width=350, height=250, left=900, top=200");
	}

	/*
	   1.쿠키 유무 확인
	   2.쿠키가 있는 경우
	      2.1 popup yesNo쿠키가 설정되어 있는지 확인
	      	>> no 설정되어 있는 경우
	      		>> 24시간 경과 했다면	: 팝업창 출력
	      		>> 그렇지 않다면		: 팝업창 출력 x
	      	>> 그렇지 않은 경우
	   3.쿠키가 없는 경우
	      팝업창 출력
	 */
</script>
</head>
<body>
	<%
		String id = "";
		Cookie[] cookies = request.getCookies(); // 요청에서 쿠키를 가져온다.
		if (cookies != null) { // 쿠키가 Null이 아닐때,
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("yesNo")) { // 쿠키의 이름이 yesNo 일때
					id = cookies[i].getValue(); // 해당 쿠키의 값을 id 변수에 저장
				}
			}
			if (id.equals("")) { // 쿠키에서 이름 id를 찾지 못했을때
				out.print("<script>popupOpen()</script>");
			} else if (id.equals("yes")) { // 쿠키에서 yes를 찾았을 때
			}
		} else { // 요청에서 쿠키가 없을때
			out.print("<script>popupOpen()</script>");
		}
	%>

	<%
		Cookie[] cookies1 = request.getCookies();
		if (cookies1 != null && cookies1.length > 0) {
			for (int i = 0; i < cookies1.length; i++) {
				out.print("쿠키 이름 : " + cookies1[i].getName() + " | 값 : " + cookies1[i].getValue() + "<BR />");
			}
		}
	%>
	<h3>COOKIE POPUP</h3>
</body>
</html>
