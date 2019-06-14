<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
        	<!-- Board Register -->
        	<!-- Board Read Page -->
        	Board Modify Page</h1>
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
                <!-- Board Read Page -->
                Board Modify Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
				<!-- 게시물 수정 폼 -->	
				<form role="form" method="post" action="/board/modify">
					<!-- 페이지 번호와 페이지 당 표시 개수 파라미터 추가 -->
					<input type="hidden"  
						   name="pageNum" value="${cri.pageNum }">
					<input type="hidden"  
						   name="amount" value="${cri.amount }">
					<!-- 검색 조건과 키워드 파라미터 추가 -->	   
					<input type="hidden"  
						   name="type"    value="${cri.type }">
					<input type="hidden"  
						   name="keyword" value="${cri.keyword }">
					
					<div class="form-group">
						<label>Bno</label>
						<input class="form-control" name="bno"
							   readonly="readonly"  value="${board.bno}"></div>
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title"
							   value="${board.title}"></div>		
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" 
								  name="content">${board.content }</textarea></div>			
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer"
							   readonly="readonly"  value="${board.writer}"></div>	
					<!-- 등록일자 및 수정일자 -->		   
					<%-- <input type="hidden" name="regdate"
                   	   	   value="<fmt:formatDate value="${board.regdate}"
                   	   	   					      pattern="yyyy-MM-dd"/>">
					<input type="hidden" name="updateDate"
						   value="<fmt:formatDate value="${board.updateDate}"
                   	   	   					      pattern="yyyy-MM-dd"/>"> --%>
					<button type="submit" 
							data-oper="modify" class="btn btn-default">
						Modify</button>	<!-- 수정 처리 -->
					<button type="submit" 
							data-oper="remove" class="btn btn-danger">
						Remove</button>	<!-- 삭제 처리 -->
					<button data-oper='list' class="btn btn-info">
						List</button>	<!-- 목록 페이지 이동 -->
				</form>
				<!-- END 게시물 등록 폼 -->			
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<!-- /.row -->
 
<script>
$(function(){
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		console.log("operation : " + operation);
		
		if(operation === 'remove'){ 		//삭제 버튼이 눌린 경우 
			formObj.attr("action", "/board/remove");
		} else if(operation === 'list') {	//목록 버튼이 눌린 경우
//			self.location = "/board/list";	
//			return;

			//페이지 번호와 게시물 개수 복사
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			
			//검색 조건과 키워드 복사
			var typeTag = $("input[name='type']").clone();
			var keywordTag = $("input[name='keyword']").clone();

			formObj.attr("action", "/board/list")
				   .attr("method", "get");
			formObj.empty();	//폼 태그 모든 내용을 지움
			
			//페이지 번호와 게시물 개수만 폼에 추가
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			
			//검색 조건과 키워드 폼에 추가 
			formObj.append(typeTag);
			formObj.append(keywordTag);
			
		}
		formObj.submit();
	});
});
</script>
<%@ include file="../includes/footer.jsp" %>

















