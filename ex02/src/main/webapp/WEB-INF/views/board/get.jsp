<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
					<div class="form-group">
						<label>Bno</label> 
						<input type="text" class="form-control" name="Bno" value='${board.bno }' readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>Title</label> 
						<input type="text" class="form-control" name="title" value='${board.title }' readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>Text area</label> 
						<textarea class="form-control" rows="3" name="content" readonly="readonly">
						<c:out value="${board.content }" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> 
						<input type="text" class="form-control" name="writer" value='${board.writer }' readonly="readonly"/>
					</div>
					<button data-oper="modify" class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno }" />'">Modify</button>
					<button data-oper="list" class="btn btn-default" onclick="location.href='/board/list'">List</button>
					
					<form id='operForm' action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"/>'>
						<!-- 페이지 번호와 페이지 당 표시 개수 파라미터 추가 -->
						<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
						<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>'>
						<!-- 검색 키워드의 조건 파라미터 추가 -->
						<input type="hidden" name='type' value='<c:out value="${cri.type }"/>'>
						<input type="hidden" name='keyword' value='<c:out value="${cri.keyword }" />'>
					</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
<!-- /.row -->
<script type="text/javascript">
	$(function(){
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		});
	});
</script>

<%@include file="../includes/footer.jsp"%>