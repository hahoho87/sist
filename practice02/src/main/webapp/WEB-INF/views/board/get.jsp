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
					<div class="form-group">
						<label>Bno</label> <input type="text" class="form-control" name="bno" value='<c:out value="${board.bno }"/>' readonly="readonly" />
					</div>
					<div class="form-group">
						<label>Title</label> <input type="text" class="form-control" name="title" value='<c:out value="${board.title }"/>' readonly="readonly" />
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content }" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input type="text" class="form-control" name="writer" value='<c:out value="${board.writer }"/>' readonly="readonly" />
					</div>
					<button data-oper='modify' class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button>
					<button data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">List</button>

					<form id='operForm' action="/board/modify" method="get">
						<input type="hidden" name="bno" value='<c:out value="${board.bno }"/>' /> <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'> <input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>'> <input type="hidden" name="type" value='<c:out value="${cri.type }"/>'> <input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
					</form>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->

		<!-- 댓글 목록 -->
		<div class="card mb-3">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="card-header">
						<i class="fa fa-comments fa-fw"></i>Reply
						<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
					</div>
					<!-- /.panel-heading -->

					<div class="card-body">
						<ul class="chat">
						</ul>
					</div>
					<!-- /.panel-body -->
					
					<!-- 댓글 목록 페이징 -->
					<div class="panel-footer"></div>
					<!-- END 댓글 목록 페이징 -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->
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
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
$(function() {
	var bnoValue = '<c:out value="${board.bno}"/>';
	var replyUl = $('.chat');
			
	showList(1);
			
	function showList(page){
		replyService.getList({
			bno:bnoValue, page: page||1
		}, function(replyCnt, list){
			console.log("replyCnt : " + replyCnt);
			console.log("list : " + list);

			if(page == -1){
				pageNum = Math.ceil(replyCnt / 10.0);
				showList(pageNum);
				return;
			}
			
			var str = "";
			if(list == null || list.length == 0){
				replyUL.html("");
				return;
			}
			for(var i = 0, len = list.length || 0; i < len; i++){
				str += "<li class='left clearfix' data-rno='" + list[i].rno +"'>";
				str += "	<div><div class='header'><strong class='primary-font'>" + list[i].replyer + "</strong>";
				str += "	<small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate)+"</small></div>";
				str += "	<p>"+list[i].reply+"</p></div></li>";
			}
			replyUl.html(str);
			
			showReplyPage(replyCnt);
		});//end function
	}//End showList
	
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
		replyPageFooter.html(str);
	}//END showReplyPage()
	
	//댓글 페이지 번호 클릭 시 지정된 댓글 목록 가져오기
	replyPageFooter.on('click', 'li a', function(e){
		e.preventDefault();
		
		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showList(pageNum);
	});
	
	var modal = $('.modal');
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalModBtn = $('#modalModBtn');
	var modalRemoveBtn = $('#modalRemoveBtn');
	var modalRegisterBtn = $('#modalRegisterBtn');
	
	$('#addReplyBtn').on('click', function(e){
		modal.find('input').val("");	//입력 양식 초기화
		
		//댓글 등록과 관계없는 요소들 안보이게 처리
		modalInputReplyDate.closest('div').hide();	
		modal.find("button[id != 'modalCloseBtn']").hide();
		modalRegisterBtn.show();	//등록버튼은 보이게
		$(".modal").modal('show');		//모달창 보이기
	});
	
	//댓글 등록 버튼 이벤트 처리
	modalRegisterBtn.on('click', function(e){
		var reply = {
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val(),
				bno : bnoValue
		};
		
		replyService.add(reply, function(result){
			alert(result);
			
			modal.find("input").val("");
			modal.modal("hide");
			
			//페이지 갱신
			showList(1);
		});
	});//END 댓글 등록 버튼 이벤트 처리
	
	//댓글 클릭 이벤트 처리
	$('.chat').on('click', 'li', function(e){
		var rno = $(this).data('rno');
		
		replyService.get(rno,
			function(data){	//댓글 가져오기 성공
				modalInputReply.val(data.reply);	//모달 창에 값 출력
				modalInputReplyer.val(data.replyer)
				modalInputReplyDate.val(replyService.displayTime(data.replyDate))
								   .attr('readonly', 'readonly'); 
				modal.data('rno', data.rno);		//댓글 번호 추가 
				
				//불필요한 요소들 숨기기
				modal.find("button[id != 'modalCloseBtn']").hide();
				modalModBtn.show();
				modalRemoveBtn.show();
				
				modal.modal('show');				//모달창 보이기
				console.log('get result : ' + data);
			});//END get() 호출
	});//END 댓글 클릭 이벤트 처리

	//댓글 수정
	modalModBtn.on('click', function(e){
		replyService.update(
			{ 	rno   : modal.data('rno'), 
				reply : modalInputReply.val() }, 
			function(result){		//수정 성공
				console.log('update result : ' + result);
			
				if(result === 'success') { alert("Updated!"); }
				
				modal.modal('hide');//모달창 닫고
				showList(pageNum);		//신규 댓글 목록 가져오기
			},
			function(err){	alert("error!");	}
		);//END remove() 호출
	});
	
	//댓글 삭제
	modalRemoveBtn.on('click', function(e){
		var rno = modal.data("rno");
		
		replyService.remove(rno, function(result){
			alert(result);
			modal.modal("hide");
			showList(pageNum);
		});
	})//End delete();
	
	
	
});
	$(function() {
		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/board/modify").submit();
		});

		$("button[data-oper='list']").on("click", function(e) {
			//list로 이동하는 경우 bno값이 필요없기 때문에 삭제
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		});
	});
	
	
	
</script>

<%@include file="../includes/footer.jsp"%>