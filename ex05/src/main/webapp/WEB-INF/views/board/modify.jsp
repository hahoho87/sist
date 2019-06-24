<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ include file="../includes/header.jsp" %>
<style>
.uploadResult { width:100%;	background-color:gray; }
.uploadResult ul { 	display:flex; 	justify-content:center;
					flex-flow:row;	align-items: center; }	
.uploadResult ul li { list-style: none;		padding:10px; }						
.uploadResult ul li img { width:100px; }

.uploadResult ul li span { color: white; }
.bigPictureWrapper {	position:absolute;	justify-content: center;		
						display: none;		align-items:center;
						top: 0%;			z-index: 100;
						width:100%;			height:100%;
						background-color: lightgray; 
						background:rgba(255 255 255 0.5);}
.bigPicture {	position: relative;			display: flex;
				justify-content: center;	align-items: center;}						 
.bigPicture img { width: 600px; }	
</style>
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
 
 <!-- 첨부파일 표시 영역 -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Files</div><!-- /.panel-heading -->
            
            <div class="panel-body">
            	<!-- 첨부파일 추가 -->
            	<div class='uploadDiv'>
					<input type="file" name="uploadFile" multiple>
				</div>
				
				<!-- 섬네일 이미지 원본 표시 -->
				<div class="bigPictureWrapper">
					<div class="bigPicture">
					</div>	
				</div>
				<!-- END 섬네일 이미지 원본 표시 -->
				
				<!-- 업로드 결과 출력 -->
				<div class="uploadResult">
					<ul>
					</ul>
				</div>	
				<!-- END 업로드 결과 출력 -->
            </div><!-- /.panel-body -->
        </div> <!-- /.panel -->
    </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
 <!-- END 첨부파일 표시 영역 -->
<script>
$(function(){
	//첨부파일 목록 가져오기
	(function(){	
		var bno = '<c:out value="${board.bno}"/>';
		
		$.getJSON("/board/getAttachList", {bno:bno}, function(arr){
			console.log('getAttachList----------------');
			console.log(arr);	
			
			//첨부파일 목록
			if(!arr || arr.length == 0){
				return;
			}

			var uploadUL = $('.uploadResult ul');
			var str = "";
			$(arr).each(function(i, obj){
				//업로드 파일명 <li>추가
				if(obj.fileType){	//이미지인 경우
					var fileCallPath = encodeURIComponent(obj.uploadPath + 
													      "/s_" + obj.uuid  + "_" +
													      obj.fileName);

				str += "<li data-path='" + obj.uploadPath + "' " 			+
						   "data-uuid='" + obj.uuid + "' " 					+
						   "data-filename='" + obj.fileName + "'" 			+
						   "data-type='" + obj.fileType + "'>" 				+ 
						   "<div><span>" + obj.fileName + "</span>"			+
					       "    <button type='button' " 					+ 
					       "            data-file='" + fileCallPath + "'" 	+
					       "            data-type='image'" 					+
					       "        class='btn btn-warning btn-circle'>" 	+
					       "        <i class='fa fa-times'></i></button><br>" +
					       "    <img src='/display?fileName="+ fileCallPath + "'>" +
					       "    </div></li>";
				} else {		//이미지가 아닌 경우
					var fileCallPath 
					= encodeURIComponent(obj.uploadPath + 
										 "/" + obj.uuid  + "_" +
										 obj.fileName);
					var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");			
					str += "<li data-path='" + obj.uploadPath + "' " 	+
						   "    data-uuid='" + obj.uuid + "' " 			+
						   "    data-filename='" + obj.fileName + "'" 	+
						   "    data-type='" + obj.fileType + "'>" 		+ 
						   "    <div><span>" + obj.fileName + "</span>"	    +  
					       "    <button type='button' " 					+ 
					       "            data-file='" + fileCallPath + "'" 	+
					       "            data-type='image'" 					+
					       "        class='btn btn-warning btn-circle'>" 	+
					       "        <i class='fa fa-times'></i></button><br>" +
						   "    <img src='/resources/img/attach.png'></div></li>";
				}
			});
			uploadUL.append(str);
		});//END getJSON()

		//X 버튼 이벤트 처리
		$('.uploadResult').on('click', 'button', function(e){
			if(confirm('파일을 삭제하시겠습니까?')){
				var targetLi   = $(this).closest('li');
				targetLi.remove();	//해당 li 삭제
			}
		});
		//END X 표시 이벤트 처리
	})();//END 첨부파일 목록 가져오기
	
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
		} else if(operation === 'modify') {	//수정 버튼이 눌린 경우
			var str = "";
			 $('.uploadResult ul li').each(function(i, obj){	
				 var jobj = $(obj);	//첨부 파일 정보 hidden 태그로 추가
				 console.log('jobj : ' + obj);
				 str += "<input type='hidden' " +
				 		"       name='attachList[" + i + "].fileName' " +
				 		"       value='" + jobj.data("filename") + "'>";

				 str += "<input type='hidden' " +
				 		"       name='attachList[" + i + "].uuid' " +
				 		"       value='" + jobj.data("uuid") + "'>";

				 str += "<input type='hidden' " +
				 		"       name='attachList[" + i + "].uploadPath' " +
				 		"       value='" + jobj.data("path") + "'>";

				 str += "<input type='hidden' " +
				 		"       name='attachList[" + i + "].fileType' " +
				 		"       value='" + jobj.data("type") + "'>";
			 });//END 첨부 파일 정보 hidden 태그로 추가
			 formObj.append(str).submit();	//폼데이터와 함께 전송
		}
		formObj.submit();
	});//END 수정|삭제|목록 버튼 이벤트 처리
	
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");	//확장자 제한 정규표현식
	var maxSize = 5242880;	//파일 최대 업로드 크기 제한 5MB
	
	//확장자 및 파일 크기 확인 함수
	function checkExension(fileName, fileSize){
		if(fileSize >= maxSize) {	//파일 크기 확인
			alert("파일 사이즈 초과!");	//크기를 초과하면 알림 메시지 출력
			return false;
		}
		if(regex.test(fileName)) {	//확장자 확인
			alert("업로드 불가 파일");	//제한 확장자인 경우 알림 메시지 출력
			return false
		}
		return true;	//파일 크기 및 확장자 문제가 없는 경우
	}//END checkExension()
	
	//첨부파일 상태 변화 이벤트 핸들러 등록
	$("input[type='file']").change(function(e){
		var formData = new FormData();	//가상의 <form> 태그
		
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log(files);
		
		//formData 객체에 선택한 파일 추가
		for(var i=0 ; i<files.length ; i++){
			//확장자 및 파일 크기 확인
			if(!checkExension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			type : 'post',
			url :'/uploadAjaxAction',
			data : formData,
			dataType : 'json',
			contentType : false,
			processData : false,
			success : function(result){
				console.log(result);	//콘솔로 결과 확인
				
				showUploadResult(result); //
			}
		})//END .ajax()
	});//END uploadBtn 이벤트 처리 
	
	//업로드 결과 출력 처리
	function showUploadResult(uploadResultArr){
		if(!uploadResultArr || uploadResultArr.length == 0){
			return;
		}

		var uploadUL = $('.uploadResult ul');
		var str = "";
		$(uploadResultArr).each(function(i, obj){
			//업로드 파일명 <li>추가
			if(obj.image){	//이미지인 경우
				var fileCallPath = encodeURIComponent(obj.uploadPath + 
												      "/s_" + obj.uuid  + "_" +
												      obj.fileName);

			str += "<li data-path='" + obj.uploadPath + "' " 			+
					   "data-uuid='" + obj.uuid + "' " 					+
					   "data-filename='" + obj.fileName + "'" 			+
					   "data-type='" + obj.image + "'>" 				+ 
					   "<div><span>" + obj.fileName + "</span>"			+
				       "    <button type='button' " 					+ 
				       "            data-file='" + fileCallPath + "'" 	+
				       "            data-type='image'" 					+
				       "        class='btn btn-warning btn-circle'>" 	+
				       "        <i class='fa fa-times'></i></button><br>" +
				       "    <img src='/display?fileName="+ fileCallPath + "'>" +
				       "    </div></li>";
			} else {		//이미지가 아닌 경우
				var fileCallPath 
				= encodeURIComponent(obj.uploadPath + 
									 "/" + obj.uuid  + "_" +
									 obj.fileName);
				var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");			
				str += "<li data-path='" + obj.uploadPath + "' " 	+
					   "    data-uuid='" + obj.uuid + "' " 			+
					   "    data-filename='" + obj.fileName + "'" 	+
					   "    data-type='" + obj.image + "'>" 		+ 
					   "    <div><span>" + obj.fileName + "</span>"	+  
				       "    <button type='button' " 					+ 
				       "            data-file='" + fileCallPath + "'" 	+
				       "            data-type='file'" 					+
				       "        class='btn btn-warning btn-circle'>" 	+
			       	   "        <i class='fa fa-times'></i></button><br>" +
					   "    <img src='/resources/img/attach.png'></div></li>";
			}
		});
		uploadUL.append(str);
	}//END showUploadResult()
});

</script>
<%@ include file="../includes/footer.jsp" %>


