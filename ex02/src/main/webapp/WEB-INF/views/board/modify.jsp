<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<form role="form" action="/board/modify" method="post">
					<!-- 페이지 번호와 페이지 당 표시 개수 파라미터 추가 -->
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
					<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>'>
					<!-- 검색 키워드의 조건 파라미터 추가 -->
					<input type="hidden" name="type" value='<c:out value="${cri.type }"/>'>
					<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
					
					<div class="form-group">
						<label>Bno</label> 
						<input type="text" class="form-control" name="bno" value='${board.bno }' readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>Title</label> 
						<input type="text" class="form-control" name="title" value='${board.title }' />
					</div>
					<div class="form-group">
						<label>Text area</label> 
						<textarea class="form-control" rows="3" name="content"><c:out value="${board.content }" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> 
						<input type="text" class="form-control" name="writer" value='${board.writer }' readonly="readonly"/>
					</div>
<%-- 					<div class="form-group">
						<label>RegDate</label> 
						<input type="hidden" class="form-control" name="regDate" 
						value='<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" />' readonly="readonly" />
					</div>
					<div class="form-group">
						<label>UpdateDate</label> 
						<input type="hidden" class="form-control" name="updateDate" 
						value='<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" />' readonly="readonly" />
					</div> --%>
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
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
		var formObj = $("form");
		
		$('button').on("click", function(e){
			//submit 버튼의 기본 동작을 막음
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === "remove") {
				formObj.attr("action", "/board/remove");
			} else if(operation === 'list') {
				//move to list
				
				// self.location="/board/list";
				// return;
				//form 태그에 있는 데이터가 list로 전송되지 않게 하기 위해 get method로 바꾼후 지워주는 방식
				formObj.attr("action", "/board/list").attr("method", "get");
				//목록 페이지는 pageNum과 amount만 필요하므로 다른 내용은 삭제하고 필요한 내용만을 다시 추가
				//clone으로 필요한 내용만 잠시 복사
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				//form 태그 내의 모든 내용 삭제
				formObj.empty();
				//필요한 태그들만 다시 추가 한 후 /board/list 호출
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