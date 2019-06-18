<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
        	<!-- Board Register -->
        	Board Read Page</h1>
    </div>  <!-- /.col-lg-12 -->
</div>		<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <!-- DataTables Advanced Tables -->
                <!-- Board Register -->
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
				<!-- 게시물 등록 폼 -->	
				<!-- <form role="form" method="post" action="/board/register"> -->
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title"
							   readonly="readonly"  value="${board.title}"></div>		
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" 
								  name="content" 
								  readonly="readonly">${board.content }</textarea></div>			
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer"
							   readonly="readonly"  value="${board.writer}"></div>	
					<button data-oper="modify" class="btn btn-default">
						Modify</button>	<!-- 수정 페이지 이동 -->
					<button data-oper='list' class="btn btn-info">
						List</button>	<!-- 목록 페이지 이동 -->
					<!-- 폼 태그 추가 -->
					<form id="operForm" action="/board/modify">
						<input type="hidden" id="bno" 
							   name="bno" value="${board.bno }">
						<!-- 페이지 번호와 페이지 당 표시 개수 파라미터 추가 -->
						<input type="hidden"  
							   name="pageNum" value="${cri.pageNum }">
						<input type="hidden"  
							   name="amount" value="${cri.amount }">	
						<!-- 검색 조건과 키워드 파라미터 추가 -->   
						<input type="hidden"  
							   name="type" value="${cri.type }">
						<input type="hidden"  
							   name="keyword" value="${cri.keyword }">
					</form>
				<!-- </form> -->
				<!-- END 게시물 등록 폼 -->			
            </div>	<!-- /.panel-body -->
        </div>      <!-- /.panel -->
    </div>   		<!-- /.col-lg-6 -->
</div>				<!-- /.row -->
 
 <!-- 댓글 목록 -->
 <div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>Reply 
				<button id='addReplyBtn'
						class='btn btn-primary btn-xs pull-right'>
					New Reply		
				</button>
            </div><!-- /.panel-heading -->
            
            <div class="panel-body">
				<ul class="chat">
				</ul>		
            </div>	<!-- /.panel-body -->
            
            <!-- 댓글 목록 페이징 -->
            <div class="panel-footer">
            </div>
            <!-- END 댓글 목록 페이징 -->
        </div>      <!-- /.panel -->
    </div>   		<!-- /.col-lg-6 -->
</div>				<!-- /.row -->
 <!-- END 댓글 목록 -->
 
 <!-- 댓글 추가 모달 창 -->
 <!-- Modal -->
 <div class="modal fade" id="myModal" tabindex="-1" 
 	  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <button type="button" class="close" 
                 		 data-dismiss="modal" aria-hidden="true">&times;</button>
                 <h4 class="modal-title" id="myModalLabel">
                 	REPLY MODAL</h4>
             </div><!-- END modal-header -->
             
             <div class="modal-body">
				<div class="form-group">
					<label>Reply</label>
					<input class="form-control" name='reply' value='New Reply!!'>
				</div>
				<div class="form-group">
					<label>Replyer</label>
					<input class="form-control" name='replyer' value='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label>
					<input class="form-control" name='replyDate' value='2019-06-17 12:13'>
				</div>
             </div><!-- END modal-body -->
             
             <div class="modal-footer">
                 <button type="button" class="btn btn-warning"
                 		 id='modalModBtn'>Modify</button>
                 <button type="button" class="btn btn-danger"
                 		 id='modalRemoveBtn'>Remove</button>
                 <button type="button" class="btn btn-primary"
                 		 id='modalRegisterBtn'>Register</button>
                 <button type="button" class="btn btn-default" 
                 	     data-dismiss="modal"
                 	     id="modalCloseBtn">Close</button>
             </div><!-- END modal-footer -->
         </div>       <!-- /.modal-content -->
     </div>     <!-- /.modal-dialog -->
 </div> <!-- /.modal -->
 <!-- END 댓글 추가 모달 창 -->
 
 
<script src="/resources/js/reply.js"></script>
<script>
$(function(){
	console.log(replyService);
	
	var bnoValue = "${board.bno }";	//현재 게시물 번호
	var replyUl = $('.chat');
	
	showList(1);
	
	function showList(page){	//댓글 목록 <li> 구성 출력
		//replyService의 getList() - 댓글 목록 가져오기
		replyService.getList(
			{ bno:bnoValue, page:page || 1}, //페이지 번호가 없으면 1로 설정
//			function(list){
			function(replyCnt, list){//댓글 갯수 + 목록
				console.log("replyCnt : " + replyCnt);
				console.log("list : " + list);

				//page 번호가 -1인 경우
				if(page == -1){
					pageNum = Math.ceil(replyCnt/10.0);
					showList(pageNum);
					return;
				}
				
				if(list == null || list.length == 0){	//댓글 목록이 없으면 중단
				//	replyUl.html("");
					return;
				}
				
				//댓글 목록이 있으면   <ul>에 <li>로 댓글 추가
				var str = "";
				for(var i=0, len=list.length || 0 ; i<len; i++){
				//	console.log(list[i]);
					str += "<li class='left clearfix' data-rno='" + list[i].rno +"'>" +
						   "	<div><div class='header'>" +
						   " 	        <strong class='primary-font'>" + 
						   			    	list[i].replyer + "</strong>" +  
						   " 			<small class='pull-right text-muted'>" +
						   	/* 				list[i].replyDate + "</small></div>" + */
			 /*  replyService.displayTime(list[i].replyDate) + "</small></div>"+ */
				                displayTime(list[i].replyDate) + "</small></div>"+
						   " 		 <p>" + list[i].reply + "</p></div></li>";
				}
				replyUl.html(str);
				
				showReplyPage(replyCnt);  //페이징 함수 호출
			} 
		);//END getList() 호출
	}//END showList()
	
	//댓글 목록 페이징
	var pageNum = 1;
	var replyPageFooter = $('.panel-footer');
	
	function showReplyPage(replyCnt){
		var endNum = Math.ceil(pageNum / 10.0) * 10;
		var startNum = endNum - 9;
		var prev = startNum != 1;
		var next = false;
		
		if(endNum * 10 >= replyCnt){	
			endNum = Math.ceil(replyCnt / 10.0);
		}
		
		if(endNum * 10 < replyCnt){
			next = true;
		}
		
		var str = "<ul class='pagination pull-right'>";
		if(prev) {	//previous link
			str += "<li class='page-item'>" + 
				   "    <a class='page-link' href='" + (startNum -1) + "'>"+
				   "         Previous</a></li>";
		}
		
		//페이지 번호 출력 및 링크 처리
		for(var i=startNum ; i<= endNum ; i++){	
			var active = pageNum == i ? "active" : "";
			str += "<li class='page-item " + active + " '>" +
				   "    <a class='page-link' href='" + i + "'>" +
				   			i + "</a></li>";
		}
		
		if(next){	//next link
			str += "<li class='page-item'>" +
			 	   "    <a class='page-link' href='" + (endNum + 1) + "'>"+
			 	   "         Next</a></li>";
		}
		
		str += "</ul>";
		console.log(str);
		replyPageFooter.html(str);
	}//END showReplyPage()
	
	//댓글 페이지 번호 클릭 시 지정된 댓글 목록 가져오기
	replyPageFooter.on('click', 'li a', function(e){
		e.preventDefault();
		
		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showList(pageNum);
	});
	
	//모달 창 처리
	var modal = $('.modal');
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalModBtn = $('#modalModBtn');
	var modalRemoveBtn = $('#modalRemoveBtn');
	var modalRegisterBtn = $('#modalRegisterBtn');
	
	//댓글 삭제 버튼 이벤트 처리
	modalRemoveBtn.on('click', function(e){
		replyService.remove(
			modal.data('rno'), 
			function(result){	//삭제 성공
				console.log('remove result : ' + result);
				if(result === 'success') { alert("REMOVED!"); }

				modal.modal('hide');//모달창 닫고
//				showList(1);		//신규 댓글 목록 가져오기
				showList(pageNum);
			},
			function(err){	alert("error!");	}
		);//END remove() 호출
	});
	
	//댓글 수정 버튼 이벤트 처리
	modalModBtn.on('click', function(e){
		replyService.update(
			{ 	rno   : modal.data('rno'), 
				bno	  : bnoValue, 
				reply : modalInputReply.val() }, 
			function(result){		//수정 성공
				console.log('update result : ' + result);
			
				if(result === 'success') { alert("Updated!"); }
				
				modal.modal('hide');//모달창 닫고
//				showList(1);		//신규 댓글 목록 가져오기
				showList(pageNum);
			},
			function(err){	alert("error!");	}
		);//END remove() 호출
	});
	
	//댓글 클릭 이벤트 처리
	$('.chat').on('click', 'li', function(e){
		var rno = $(this).data('rno');
		
		replyService.get(rno, 
			function(data){	//댓글 가져오기 성공
				modalInputReply.val(data.reply);	//모달 창에 값 출력
				modalInputReplyer.val(data.replyer).attr('readonly', 'readonly');	 
				modalInputReplyDate.val(displayTime(data.replyDate))
								   .attr('readonly', 'readonly'); 
				modal.data('rno', data.rno);		//댓글 번호 추가
				
				//불필요한 요소들 숨기기
				modal.find("button[id != 'modalCloseBtn']").hide();
				modalModBtn.show();
				modalRemoveBtn.show();
				
				modal.modal('show');				//모달창 보이기
				console.log('get result : ' + data);
			},
			function(err){	alert("error!");	}
		);//END remove() 호출
	});//END 댓글 클릭 이벤트 처리
	
	//댓글 등록 버튼 이벤트 처리
	modalRegisterBtn.on('click', function(e){
		replyService.add(	//전송할 데이터들
			{ bno	  : bnoValue, 
			  reply   : modalInputReply.val(), 
			  replyer : modalInputReplyer.val() },
			function(result){	//댓글 등록에 성공하면
				alert("RESULT : " + result);
				modal.find('input').val("");	//입력양식 비우고	
				modal.modal('hide');			//모달창 닫고
				
//				showList(1);	//신규 댓글 목록 가져오기
				showList(-1);	
			}
		);//END add() 호출 
	});//END 댓글 등록 버튼 이벤트 처리
	
	$('#addReplyBtn').on('click', function(e){
		modal.find('input').val("");	//입력 양식 초기화
		
		//댓글 등록과 관계없는 요소들 안보이게 처리
		modalInputReplyDate.closest('div').hide();	
		modal.find("button[id != 'modalCloseBtn']").hide();
		modalInputReplyer.removeAttr('readonly');	
		modalRegisterBtn.show();	//등록버튼은 보이게
		modal.modal('show');		//모달창 보이기
	});
	
});
</script>
<script>
function displayTime(timeValue){
	var today = new Date();
	var dateObj = new Date(timeValue);
	var str = "";
	
	//댓글 등록일이 오늘이면  '시:분:초' 표시
	if(today.getDate() === dateObj.getDate()){
		 var hh = dateObj.getHours() ;
		 var mi = dateObj.getMinutes();
		 var ss = dateObj.getSeconds();
		 
		 return [ (hh > 9 ? '' : '0') + hh, ":" ,
			 	  (mi > 9 ? '' : '0') + mi, ":" ,
			 	  (ss > 9 ? '' : '0') + ss ].join('');
	} else { //그렇지 않으면 '연/월/일' 표시
		var yy = dateObj.getFullYear();
		var mm = dateObj.getMonth() + 1;
		var dd = dateObj.getDate();
		
		return [ yy, '/', 
				 (mm > 9 ? '' : '0') + mm, '/',
				 (dd > 9 ? '' : '0') + dd].join('');			
	}
}; //END displayTime()

$(function(){
	var operForm = $("#operForm");
	
	//수정 버튼 이벤트 처리
	$('button[data-oper="modify"]').on("click", function(e){
		operForm.attr("action", "/board/modify")
		        .submit();
	});	

	//목록 버튼 이벤트 처리
	$('button[data-oper="list"]').on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action", "/board/list");
		operForm.submit();
	});	
});
</script>
<%@ include file="../includes/footer.jsp" %>















