<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>\

<h3>Spring file upload with AJAX</h3>

<div class='uploadDiv'>
	<input type='file' name='uploadFile' multiple>
</div>
<button id='uploadBtn'>Upload</button>

<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>

<script>
    $(document).ready(function(){
    	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");	//확장자 제한 정규표현식
    	var maxSize = 5242880; //파일 최대 업로드크기 제한 5MB
    	
    	//확장자 및 파일 크기 확인 함수
    	function checkExtension(fileName, fileSize){
    		if(fileSize >= maxSize) {	//파일 크기 확인
    			alert("파일 사이즈 초과");	//크기를 초과하면 알림 메시지 출력
    			return false;			//return false
    		}
    			
    		if(regex.test(fileName)) {		//확장자 확인
    			alert("해당 종류의 파일은 업로드할 수 없습니다.")	//제한 확장자인 경우 알림 메시지 출력
    			return false;		//return false
    		}	
    		//파일 크기 및 확장자 문제가 없는 경우
    		return true;
    	}
    	
        //id가 uploadBtn에게 click 이벤트 핸들러 등록
        $("#uploadBtn").on("click", function(e){
            var formData = new FormData();  //가상의 <Form>태그
            var inputFile = $("input[name='uploadFile']");
            var files = inputFile[0].files;
            console.log(files);

            //formData 객체에 선택한 파일 추가
            for(var i=0; i<files.length; i++) {
            	if(!checkExtension(files[i].name, files[i].size)) {
            		return false;
            	}
            	
            	formData.append("uploadFile", files[i]);
            }
            
            $.ajax({
    			type : 'POST',
    			url : '/uploadAjaxAction',
    			data : formData,
    			contentType : false,
    			processData : false,
    			// 성공이면 (RequestEntity 200이 넘어오면)
    			success : function(result) {
    				alert("Uploaded");
    			}

    		});
        });//End uploadBtn Event
    });//End $
</script>  


</body>
</html>