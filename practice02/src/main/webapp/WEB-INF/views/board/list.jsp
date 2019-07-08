<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/board/list">Dashboard</a></li>
			<li class="breadcrumb-item active">Tables</li>
		</ol>

		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Spring Board
				<button id="regBtn" type="button" class="btn btn-outline-primary pull-right">Register New Board</button>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>No.</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Register Date</th>
								<th>Update Date</th>
							</tr>
						</thead>
						<!-- Model Data -->
						<c:forEach items="${list }" var="board">
							<tr>
								<td><c:out value="${board.bno }"/></td>
								<td><a class="move" href="${board.bno}">
                   	   	   	   	${board.title }</a></td>
								<td><c:out value="${board.writer }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									 value="${board.regDate }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									 value="${board.updateDate }"/></td>	 
						</c:forEach>
					</table>
					
									   <!-- 검색창 - 검색 조건 및 키워드 입력 영역 -->
                   <div class='row'>
				   	   <div class="col-lg-12">
				   	   <form id="searchForm" action="/board/list">
				   	   	   <select name="type">
				   	   	   	  <c:set var="type" value="${pageMaker.cri.type }"/>
				   	   	      <!-- 검색 조건이 없을 경우 selected 표시 -->
				   	   	   	  <option value=""
				   	   	   	  	<c:out value="${pageMaker.cri.type == null ? 'selected' : '' }"/>>
				   	   	   	  	검색 조건 지정</option>
				   	   	   	  <!-- ${pageMaker.cri.type}이 value와 일치하면 selected 표시 -->
				   	   	   	  <option value="T"
				   	   	   	  	<c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : '' }"/>>제목</option>
				   	   	   	  <option value="C"
				   	   	   	  	<c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : '' }"/>>내용</option>
				   	   	   	  <option value="W"
				   	   	   	  	<c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : '' }"/>>작성자</option>
				   	   	   	  <option value="TC"
				   	   	   	  	<c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : '' }"/>>제목 or 내용</option>
				   	   	   	  <option value="TW"
				   	   	   	  	<c:out value="${pageMaker.cri.type eq 'TW' ? 'selected' : '' }"/>>제목 or 작성자</option>
				   	   	   	  <option value="TCW"
				   	   	   	  	<c:out value="${pageMaker.cri.type eq 'TWC' ? 'selected' : '' }"/>>제목 or 내용 or 작성자</option>
				   	   	   </select>
				   	   	   <input type="text" name="keyword" 
				   	   	    	  value="${pageMaker.cri.keyword }">
				   	   	   <input type="hidden" name="pageNum"
				   	   	   		  value="${pageMaker.cri.pageNum }">
				   	   	   <input type="hidden" name="amount"
				   	   	   		  value="${pageMaker.cri.amount }">
				   	   	   <button class="btn btn-warn">Search</button>
				   	   </form>
				   	   </div>                   
                   </div>
                   <!-- END 검색창 - 검색 조건 및 키워드 입력 영역 -->
					
                 <!-- 페이지 번호 출력 -->
				   <div class="pull-right">
				   		<ul class="pagination">
				   		<c:if test="${pageMaker.prev }"><!-- previous 버튼 표시 -->
				   			<li class="page-link paginate_button prev">
				   				<a href="${pageMaker.startPage - 1 }">
				   					Previous</a></li>
				   		</c:if>
				   						   		
				   		<!-- 페이지 번호 표시 -->
				   		<c:forEach begin="${pageMaker.startPage }"
				   				   end="${pageMaker.endPage }" var="num">
				   			<li class="page-link paginate_button"
				   			           ${pageMaker.cri.pageNum == num ? 'active': '' }>
				   				<a href="${num }">${num }</a></li>
				   		</c:forEach>
				   		
				   		<c:if test="${pageMaker.next }"><!-- next 버튼 표시 -->
				   			<li class="page-link paginate_button next">
				   				<a href="${pageMaker.endPage + 1 }">Next</a></li>
				   		</c:if>
				   		</ul>
				   </div>
				   <!-- END 페이지 번호 출력 -->
				   
				   <!-- a 태그 대신 pageNum과 amount 파라미터로 전송 -->
				   <form id="actionForm" action="/board/list">
				   	   <input type="hidden" name="pageNum" 
				   	   	      value="<c:out value='${pageMaker.cri.pageNum }'/>">
				   	   <input type="hidden" name="amount" 
				   	   	      value="<c:out value='${pageMaker.cri.amount }'/>">
				   	   <input type="hidden" name="type" 
				   	   	      value="<c:out value='${pageMaker.cri.type }'/>">
				   	   <input type="hidden" name="keyword" 
				   	   	      value="<c:out value='${pageMaker.cri.keyword }'/>">   	      
				   </form>	   	      
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">게시물 수정 및 삭제 완료</h4>
					</div>
					<div class="modal-body">처리가 완료되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		
<script type="text/javascript">

	$(function() {
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		//뒤로가기 history 처리
		history.replaceState({}, null, null);
		
		function checkModal(result) {
			if(result === '' || history.state){
				return;
			}
			if(parseInt(result) > 0) {
				$(".modal-body").html(parseInt(result) + "번 글이 등록되었습니다.")
			}
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
		
		//페이지 번호를 클릭하면 해당 페이지 목록 표시
		var actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e){
			e.preventDefault();	//a 태그 기본 동작 막기
			
			//pageNum의 값을 클릭된 a의 href 값으로 변경
			actionForm.find("input[name='pageNum']")
				      .val($(this).attr('href'));
			//폼 전송
			actionForm.submit();
		});
		
		//a 태그의 move 클래스 속성을 이용
 		$(".move").on("click", function(e){
			e.preventDefault();	
			
			actionForm.append("<input type='hidden' name='bno' value='"+
							 $(this).attr('href')+"'>'");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		}); 
		
		
		//검색 버튼 이벤트 처리
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			if(!searchForm.find("option:selected").val()){
				alert("검색 종류를 선택하세요");
				return false;
			}
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			//검색 후 1페이지로 이동
			serachForm.find("input[name='pageNum']").val(1);
			e.preventDefault();
			serachForm.submit();
		});
	});
	
</script>
		

<%@include file="../includes/footer.jsp"%>