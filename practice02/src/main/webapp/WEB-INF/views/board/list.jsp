<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
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
						<c:forEach items="${list }" var="board">
							<tr>
								<td><c:out value="${board.bno }"/></td>
								<td><a href="#"><c:out value="${board.title }"/></a></td>
								<td><c:out value="${board.writer }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									 value="${board.regDate }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									 value="${board.updateDate }"/></td>	 
						</c:forEach>
					</table>
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
						<h4 class="modal-title" id="myModalLabel">게시물 등록 완료</h4>
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
		
		function checkModal(result) {
			if(result == ''){
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
	});
	
	
	
</script>
		

<%@include file="../includes/footer.jsp"%>