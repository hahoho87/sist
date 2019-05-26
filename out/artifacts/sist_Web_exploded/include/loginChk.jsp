<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 	
> 세션의 sid 속성에 값이 있으면
   > logout 버튼 출력하고,
   > logout 버튼이 눌리면 
   > 로그아웃 의사를 확인한 후 logout.jsp로 이동 -->
 <% if(session.getAttribute("sid") != null) { %>
   <button type="button" onclick="logout()">
   		로그아웃
   </button>
 <% } else { %>
	<script>
		alert("회원 전용 페이지입니다.\n로그인 후 이용해 주세요.");
		location.replace('/webex/member/join03.jsp');
	</script>   
 <% }%>
	   
<script>
function logout(){
	var result = confirm("로그아웃하시겠습니까?");
	if(result == true){
		location.href="/webex/member/logout.jsp";
	}
}
</script>