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
				<i class="fas fa-table"></i> Spring Modify
			</div>
			<div class="card-body">
				<div class="table-responsive">
				
				<form role="form" action="/board/modify" method="post">
				<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
				<input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
				<input type="hidden" name="type" value="<c:out value='${cri.type }'/>">
				<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }'/>"> 
					<div class="form-group">
						<label>Bno</label> 
						<input type="text" class="form-control" name="bno"
							value='<c:out value="${board.bno }"/>' readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label>Title</label> 
						<input type="text" class="form-control" name="title"
							value='<c:out value="${board.title }"/>' />
					</div>
					
					<div class="form-group">
						<label>Text area</label> 
						<textarea class="form-control" rows="3" name="content"><c:out value="${board.content }"/>
						</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input type="text" class="form-control" name="writer"
							value='<c:out value="${board.writer }"/>' readonly="readonly"/>
					</div>
 
					<button type='submit' data-oper='modify' 
							class="btn btn-default">Modify
					</button>
					<button type='submit' data-oper='remove' 
							class="btn btn-danger">Remove
					</button>
					<button
						type='submit' data-oper='list' class="btn btn-info">
							List
					</button>
				</form>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->

<script>
	//버튼 처리
	$(function() {
		
		var formObj = $("form");
		
		$('button').on("click", function(e){
			e.preventDefault();
			
			var operation = $(this).data("oper");
			console.log(operation);
			
			if(operation === 'remove')	{
				formObj.attr("action", "/board/remove");
			} else if(operation ==='list') {
				//move to list
				formObj.attr("action", "/board/list").attr("method", "get");
				//필요한 부분만 잠시 복사해서 저장
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}
			formObj.submit();
		});
	});
</script>

<%@include file="../includes/footer.jsp"%>