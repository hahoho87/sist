<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
        	<!-- Board Register -->
        	Board Read Page</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <!-- DataTables Advanced Tables -->
                <!-- Board Register -->
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
				<!-- 게시물 등록 폼 -->	
				<!-- <form role="form" method="post" action="/board/register"> -->
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title"
							   readonly="readonly"  value="${board.title}"></div>		
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" 
								  name="content" 
								  readonly="readonly">${board.content }</textarea></div>			
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer"
							   readonly="readonly"  value="${board.writer}"></div>	
					<button data-oper="modify" class="btn btn-default">
						Modify</button>	<!-- 수정 페이지 이동 -->
					<button data-oper='list' class="btn btn-info">
						List</button>	<!-- 목록 페이지 이동 -->
					<!-- 폼 태그 추가 -->
					<form id="operForm" action="/board/modify">
						<input type="hidden" id="bno" 
							   name="bno" value="${board.bno }">
						<!-- 페이지 번호와 페이지 당 표시 개수 파라미터 추가 -->
						<input type="hidden"  
							   name="pageNum" value="${cri.pageNum }">
						<input type="hidden"  
							   name="amount" value="${cri.amount }">	
						<!-- 검색 조건과 키워드 파라미터 추가 -->   
						<input type="hidden"  
							   name="type" value="${cri.type }">
						<input type="hidden"  
							   name="keyword" value="${cri.keyword }">
					</form>
				<!-- </form> -->
				<!-- END 게시물 등록 폼 -->			
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<!-- /.row -->
<script src="/resources/js/reply.js"></script>
<script>
$(function(){
	var operForm = $("#operForm");
	
	//수정 버튼 이벤트 처리
	$('button[data-oper="modify"]').on("click", function(e){
		operForm.attr("action", "/board/modify")
		        .submit();
	});	

	//목록 버튼 이벤트 처리
	$('button[data-oper="list"]').on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action", "/board/list");
		operForm.submit();
	});	
});
</script>
<%@ include file="../includes/footer.jsp" %>

<script>
	$(function(){
		console.log(replyService);
	});

	//게시물 추가 test
	console.log("=============");
	console.log("JS TEST");

	var bnoValue = '<c:out value="${board.bno}"/>';	//현재 게시물 번호

	//replySerive의 add()테스트
/* 	replyService.add(
		{bno : bnoValue, reply : "reply.js 댓글", replyer : "rrr"}
		,
		function(result) {
			alert("RESULT : " + result);
		}
	) */
	
	//reply List Test
	replyService.getList({bno:bnoValue, page:1}, function(list){
		for(var i = 0, len = list.length||0; i < len; i++){
			console.log(list[i]);
		}
	});//END getList
	
	//reply Delete Test
	replyService.remove(29, function(count){
		console.log(count);
		
		if(count === "success") {
			alert("REMOVED");
		}
	}, function(err){
		alert('ERROR...');
	});

</script>







