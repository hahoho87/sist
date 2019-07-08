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
					<form role="form" action="/board/register" method="post">
					<div class="form-group">
						<label>Title</label> <input type="text" class="form-control" name="title"/>
					</div>
					<div class="form-group">
						<label>Text area</label> <textarea class="form-control" rows="3" name="content"></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input type="text" class="form-control" name="writer"/>
					</div>
					<button type="submit" class="btn btn-secondary">Submit</button>
					<button type="reset" class="btn btn-primary">Reset</button>
				</form>
					
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->

<%@include file="../includes/footer.jsp"%>