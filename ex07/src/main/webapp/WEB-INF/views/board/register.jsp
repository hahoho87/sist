<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<style>
.uploadResult {
	width: 100%;
	background-color: lightgray;
}

.uploadResult ul {
	display: flex;
	justify-content: center;
	flex-flow: row;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}

.uploadResult ul li span {
	color: white;
}

.bigPictureWrapper {
	position: absolute;
	justify-content: center;
	display: none;
	align-items: center;
	top: 0%;
	z-index: 100;
	width: 100%;
	height: 100%;
	background-color: lightgray;
	background: rgba(255 255 255 0.5);
}

.bigPicture {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
}

.bigPicture img {
	width: 600px;
}
</style>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<!-- DataTables Advanced Tables -->
				Board Register
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<!-- 게시물 등록 폼 -->
				<form role="form" method="post" action="/board/register">
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title">
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" name="content"></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
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

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">FILE ATTACH</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group uploadDiv">
					<div class='uploadDiv'>
						<input type="file" name="uploadFile" multiple>
					</div>

					<!-- 섬네일 이미지 원본 표시 -->
					<div class="bigPictureWrapper">
						<div class="bigPicture"></div>
					</div>
					<!-- END 섬네일 이미지 원본 표시 -->

					<!-- 업로드 결과 출력 -->
					<div class="uploadResult">
						<ul>
						</ul>
					</div>
					<!-- END 업로드 결과 출력 -->
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
<!-- /.row -->

<script>
	$(document).ready(function(e) {
		
		var formObj = $("form[role='form']");
		
		//Submit Button Event
		$("button[type='submit']").on("click", function(e) {
			//Submit Button 기본 동작 막기
			e.preventDefault();
			console.log("submit clicked");
			
			var str = "";
			
			$(".uploadResult ul li").each(function(i, obj){
				var jobj = $(obj);
				console.dir(jobj);
				
				str += "<input type='hidden' " + 
					   		  "name='attachList["+i+"].fileName' " + 
					   		  "value='"+jobj.data("filename")+"'>";
				str += "<input type='hidden' " + 
					   		  "name='attachList["+i+"].uuid' " + 
					   		  "value='"+jobj.data("uuid")+"'>";	   
				str += "<input type='hidden' " + 
					   		  "name='attachList["+i+"].uploadPath' " + 
					   		  "value='"+jobj.data("path")+"'>";
				str += "<input type='hidden' " + 
					   		  "name='attachList["+i+"].fileType' " + 
					   		  "value='"+jobj.data("type")+"'>";
			});
			formObj.append(str).submit();
			
		});
	
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$"); //확장자 제한 정규표현식
		var maxSize = 5242880; //파일 최대 업로드 크기 제한 5MB
	
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
		
		//첨부파일 상태 변경 이벤트 핸들러 등록
		$("input[type='file']").change(function(e){
			var formData = new FormData();	//가상의 <form> 태그
			
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			
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
					
					showUploadResult(result); //업로드 결과 처리 함수
					
				}
			})//END .ajax()
			
			//업로드 결과 출력 처리
			
			function showUploadResult(uploadResultArr){
				
				if(!uploadResultArr || uploadResultArr.length == 0) {return;}
				
				var uploadUL = $('.uploadResult ul');
				var str = "";
				$(uploadResultArr).each(function(i, obj){
					//업로드 파일명 <li>추가
					if(obj.image){	//이미지인 경우
						//섬네일 파일명 인코딩 처리
						var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid  + "_" + obj.fileName);
						//원본 이미지 경로 및 파일명
						var originPath = obj.uploadPath + "\\" + obj.uuid  + "_" + obj.fileName;
						// 경로 구분자 \를 /로 변경
						originPath = originPath.replace(new RegExp(/\\/g), "/");
						
						str += "<li data-path='"+obj.uploadPath+"'";
						str += " data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'";
						str += "><div>";
						str += "<span> " + obj.fileName + "</span>";
						str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-warning btn-circle'>";
						str += "<i class='fa fa-times'></i></button><br>";
						str += "<img src='/display?fileName=" + fileCallPath + "'>";
						str += "</div></li>"
						
					} else {		//이미지가 아니면 다운로드 링크 작성
						
						var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid  + "_" +
								 obj.fileName);
						
						var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
						str += "<li ";
						str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
						str += "<span> " + obj.fileName + "</span>";
						str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
						str += "<img src='/resources/img/attach.png'></a>";
						str += "</div></li>";
					}
				});
				
				uploadUL.append(str);
			}//END showUploadResult()
			
			//X버튼 클릭 이벤트
			$(".uploadResult").on("click", "button", function(e){
				console.log("delete file");
				
				var targetFile 	= $(this).data("file");
				var type		= $(this).data("type");
				var targetLi 	= $(this).closest("li");
				
				$.ajax({
					url :'/deleteFile',
					data : {fileName:targetFile, type:type} ,
					dataType : 'text',
					type : 'POST',
					success : function(result){
						alert(result);
						targetLi.remove();
					}
				})//$.ajax
			})// X button Event
			
		});//END change function
	
	})//END $
</script>

<%@ include file="../includes/footer.jsp"%>









