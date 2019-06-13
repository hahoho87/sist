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
								<td><c:out value="${board.title }"/></td>
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



		<%@include file="../includes/footer.jsp"%>