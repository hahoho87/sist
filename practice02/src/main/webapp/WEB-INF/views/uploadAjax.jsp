<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	<button id='uploadBtn'>Upload</button>
	
<!-- jQuery 지정  -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" 
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" 
		crossorigin="anonymous"></script>
	
<script>
	$(document).ready(function(){
		$("#uploadBtn").on("click", function(e){
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
				url: '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type : 'POST',
				success : function(result){
					alert("Uploaded");
				}
			}); //End ajax
			
		});
	});
</script>		
			
</body>
</html>