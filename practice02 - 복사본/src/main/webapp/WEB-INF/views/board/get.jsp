<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Register</li>
		</ol>

		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Spring Register
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div class="form-group">
						<label>Bno</label> 
						<input type="text" class="form-control" name="bno"
							value='<c:out value="${board.bno }"/>' readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>Title</label> 
						<input type="text" class="form-control" name="title"
							value='<c:out value="${board.title }"/>' readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>Text area</label> 
						<textarea class="form-control" rows="3" name="content"
						 readonly="readonly"><c:out value="${board.content }"/></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input type="text" class="form-control" name="writer"
							value='<c:out value="${board.writer }"/>' readonly="readonly"/>
					</div>
					<button data-oper='modify' 
						class="btn btn-default"
						onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button>
					<button data-oper='list' 
						class="btn btn-info"
						onclick="location.href='/board/list'">List</button>
					
					<form id='operForm' action="/board/modify" method="get">
						<input type="hidden" name="bno"
							value='<c:out value="${board.bno }"/>'/>
					</form>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->

<script type="text/javascript">

	$(function() {
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			//list로 이동하는 경우 bno값이 필요없기 때문에 삭ㅈ
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		});
	});
	
</script>

		<%@include file="../includes/footer.jsp"%>