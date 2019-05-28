<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfoModify.jsp</title>
<script>
function setEmail2(email3Obj){
	var email2 = document.frm.email2;
	var email3 = email3Obj.value;
	
	if(email3 != 'direct'){	//직접 선택이 아닌 경우
		email2.value = email3;
	} else {//직접 선택인 경우
		email2.value = "";
		email2.focus();
	}
}
</script>
</head>
<body>
	<h3>
		USER INFO PAGE
	<jsp:include page="../include/loginChk.jsp" /></h3>
	<jsp:useBean id="mvo" class="webex.vo.MemberVO" scope="request" />
	<%
		//이거랑 같은 코드 >> MemberVO mvo = (MemberVO)request.getAttribute("mvo");
		//요청객체의 mvo 속성의 값을 넘겨받아서 널이 아니면 화면에 회원 정보 출력
		if (mvo != null) {
	%>
	<form action="/webex/Member.do" method="post" id="frm" name="frm">
		<input type="hidden" name="flag" value="u">
		<input type="hidden" name="userId" value="${ mvo.userId }">
	아이디 : ${ mvo.userId }<br> 
	이름 : ${ mvo.userNm }<br> 
	이메일 :	<input type="text" name="email1" value="${ mvo.email1 }">@
			<input type="text" name="email2" value="${ mvo.email2 }">
			<select name="email3" onchange="setEmail2(this)">
				<option value="direct" selected>직접입력</option>
				<option value="gmail.com">gmail.com</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
			</select><br>
	가입일자 : ${ mvo.regDate }<br> 
	생년월일 : ${ mvo.birthDate }<!-- << 이렇게 쓰거나 --> <br> 
	사진 : <img src="${ mvo.photo }">
		  <input type="file" name="photo" value="${ mvo.photo }">
	<hr>
	</form>		
	<script>
	function modify() {
		location.herf="userInfoModify.jsp"
	}
</script>
 	<button type="button" onclick="history.back()">이전으로</button>
 	<button type="reset" id="deleteBtn">다시쓰기</button>
	<button type="submit">완료</button>

	<%
		}
	%>
</body>
</html>