<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
   <div class="col-lg-12">
      <h1 class="page-header">Board Read Page</h1>
   </div><!-- /.col-lg-12 -->
</div><!-- /.row -->


<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
         <div class="panel-heading">Board Read Page</div>
         <!-- /.panel-heading -->
         <div class="panel-body">
         
         <!-- 게시물 수정 폼 -->
         
         <form role="form" method="post" action="/board/modify">
           <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>      
           <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>      
           <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>      
           <input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>      
      
         </form>
         
               <div class="form-group">
                  <label>Bno</label> 
                  <input type="text" class="form-control" name="Bno" value='${board.bno }' readonly="readonly"/>
               </div>
               <div class="form-group">
                  <label>Title</label> 
                  <input type="text" class="form-control" name="title" value='${board.title }' readonly="readonly"/>
               </div>
               <div class="form-group">
                  <label>Text area</label> 
                  <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content }" /></textarea>
               </div>
               <div class="form-group">
                  <label>Writer</label> 
                  <input type="text" class="form-control" name="writer" value='${board.writer }' readonly="readonly"/>
               </div>
               <button data-oper="modify" class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno }" />'">Modify</button>
               <button data-oper="list" class="btn btn-default" onclick="location.href='/board/list'">List</button>
               
               <!-- 폼 태그 추가 -->
               <form id='operForm' action="/board/modify" method="get">
                  <input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"/>'>
                  <input type="hidden"  name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
                  <input type="hidden"  name="amount" value='<c:out value="${cri.amount }"/>'>
                  <input type="hidden"  name="keyword" value='<c:out value="${cri.keyword }"/>'>
               </form>
               
               <!-- </form> -->
               <!-- END 게시물 등록 폼 -->
         </div><!-- /.panel-body -->
      </div><!-- /.panel -->
   </div><!-- /.col-lg-6 -->
</div><!-- /.row -->

  <!--댓글 목록 -->
  
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
	<!-- <div class="panel-heading">
         <i class = "fa fa-comments fa-fw"></i>Reply
         </div> -->
         <div class="panel-heading">
         	<i class="fa fa-comments fa-fw"></i> Reply
         	<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
         </div>
         
         <!-- /.panel-heading -->
         <div class="panel-body">
         
             <ul class="chat">
          <!--    <li class = "left clearfix" data-rno='12'>
             <div>
             <div class="header">
             <strong class = "primary-font">user00</strong>
             <small class="pull-right text-muted">2019-06-17 10:13
             </small>
             </div>
             <p>Good job!</p>
             </div>
             
             </li> -->
             </ul>
         </div><!-- /.panel-body -->
         
         	<!-- 댓글 목록 페이징 -->
         	<div class="panel-footer">
         	</div>
      </div><!-- /.panel -->
   </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
  <!-- END 댓글 목록 -->
  
  <!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Reply</label>
							<input class="form-control" name ='reply' value='New Reply!!!'>
						</div>
						<div class="form-group">
							<label>Replyer</label>
							<input class="form-control" name ='replyer' value='replyer'>
						</div>	
						<div class="form-group">
							<label>Reply Date</label>
							<input class="form-control" name ='replyDate' value=''>
						</div>
					</div>
			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
				<button id='modalCloseBtn' type="button" data-dismiss="modal" class="btn btn-default">Close</button>
			</div> </div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	<!-- /.modal -->


<script src ="/resources/js/reply.js"></script>

   <script>
      $(function() {
         console.log(replyService);
         var bnoValue = "${board.bno }"; //현재 게시물의 번호
         var replyUL = $('.chat');
         
         showList(1);
         
         function showList(page){    //댓글 목록<li> 구성 출력
     
            //replyService의 getList() - 댓글목록 가져오기
            replyService.getList(
                   {bno:bnoValue, page: page || 1}, //페이지 번호가 없을 경우 1로 설정
                   function(replyCnt, list){
                	   console.log("replyCnt : " + replyCnt);
                	   console.log("list : " + list);
                	   console.log(list);
                	   
                	   //page 번호가 -1인 경우
                	   if(page == -1) {
                		   pageNum = Math.ceil(replyCnt/10.0);
                		   showList(pageNum);
                		   return
                	   }
                   	  var str="";
                      if(list == null ||  list.length ==0){	//댓글 목록이 없으면
                         //replyUL.html("");
                         return;
                      }                 
                      
                      //댓글 목록이 있으면 <ul>에<li>로 댓글 추가
                      
                      for(var i = 0, len = list.length||0; i<len; i++){
                     str += "<li class='left clearfix' data-rno='" + list[i].rno+"'>";
                     str +=" <div> <div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
                     str +="  <small class='pull-right text-muted'>" +replyService.displayTime(list[i].replyDate)+"</small></div>";
                     str +="  <p>"+list[i].reply+"</p></div></li>";
               		
                   }
                      replyUL.html(str);
                      
                      showReplyPage(replyCnt);
                     
                   }); //end function
            } //end showList
            
            //댓글 추가 시작 시 버튼 이벤트 처리
            var modal = $(".modal");
            var modalInputReply = modal.find("input[name='reply']");
            var modalInputReplyer = modal.find("input[name='replyer']");
            var modalInputReplyDate = modal.find("input[name='replyDate']");
            
            var modalModBtn = $("#modalModBtn");
            var modalRemoveBtn = $("#modalRemoveBtn");
            var modalRegisterBtn = $("#modalRegisterBtn");
            
            $("#addReplyBtn").on("click", function(e){
            	modal.find("input").val("");	//입력 양식 초기화
            	//댓글 등록과 관계없는 요소를 안보이게 처리
            	modalInputReplyDate.closest("div").hide();
            	modal.find("button[id != 'modalCloseBtn']").hide();	//닫기 버튼 제외하고 숨김
            	modalInputReplyer.removeAttr("readonly");
            	modalRegisterBtn.show();	//등록버튼 보이게
            	
            	$(".modal").modal("show");	//modal 창 보이게
            });
            
            //새로운 댓글 추가 처리
            modalRegisterBtn.on("click", function(e) {
            	var reply = {
            			bno: bnoValue,
            			reply:modalInputReply.val(),
            			replyer: modalInputReplyer.val()
            		};
            	replyService.add(reply, function(result){
            		alert(result);
            		
            		modal.find("input").val("");	//입력양식 초기화
            		modal.modal("hide");			//modal창 닫기
            		
            	//	showList(1);	//새로 등록된 댓글이 보이게 새로고침 처리
            		showList(-1);
            	});
            });
            
            //댓글 클릭 이벤트
            $('.chat').on('click', 'li', function(e){
				var rno = $(this).data('rno');
				console.log("li rno : " + rno);	//댓글 번호 콘솔로 확인
		
				replyService.get(rno, 
					function(data){	//댓글 가져오기 성공
						modalInputReply.val(data.reply);	//모달 창에 값 출력
						modalInputReplyer.val(data.replyer).attr('readonly', 'readonly');	 
						modalInputReplyDate.val(replyService.displayTime(data.replyDate)).attr('readonly', 'readonly'); 
						
						modal.data('rno', data.rno);		//댓글 번호 추가
						//불필요한 요소들 숨기기
						modal.find("button[id != 'modalCloseBtn']").hide();
						modalModBtn.show();
						modalRemoveBtn.show();
						
						modal.modal('show');	//모달창 보이기
						console.log('get result : ' + data);
					},
					function(err){	alert("error!");	}
				);//END remove() 호출
			});//END 댓글 클릭 이벤트 처리	
			
			//댓글 수정 이벤트
			 modalModBtn.on("click", function(e){
				 var reply = {bno: bnoValue, rno: modal.data("rno"), reply: modalInputReply.val()};
				 
				 replyService.update(reply, function(result){
					 alert(result);
					 modal.modal("hide");
					 showList(pageNum);
				 });
			});
			
			//댓글 삭제 버튼 이벤트 처리
			modalRemoveBtn.on('click', function(e){
				replyService.remove( modal.data('rno'), 
					function(result){	//삭제 성공
						console.log('remove result : ' + result);
						if(result === 'success') { alert("REMOVED!"); }

						modal.modal('hide');//모달창 닫고
						showList(1);		//신규 댓글 목록 가져오기
					},
					function(err){	alert("error!");	}
				);//END remove() 호출
			});
			
			//댓글 목록 페이징
			var pageNum = 1;
			var replyPageFooter = $(".panel-footer");
			
			function showReplyPage(replyCnt) {
				
				var endNum = Math.ceil(pageNum / 10.0) * 10;
				var startNum = endNum - 9;
				
				var prev = startNum != 1;
				var next = false;
				
				if(endNum * 10 >= replyCnt)	{
					endNum = Math.ceil(replyCnt/10.0);
				}
				
				if(endNum * 10 < replyCnt) {
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
				
				str += "</ul></div>";
				console.log(str);
				replyPageFooter.html(str);
			}
			 
         });

            /*    <li class = "left clearfix" data-rno='12'>
                <div>
                <div class="header">
                <strong class = "primary-font">user00</strong>
                <small class="pull-right text-muted">2019-06-17 10:13
                </small>
                </div>
                <p>Good job!</p>
                </div>
                
                </li> */

            /*     //replyService의 add() 테스트
                replyService.add(
                      {bno:bnoValue, reply:"reply.js 댓글",replyer:"jisoo"},
               function(result){
                  alert("RESULT : " + result);
                  
               }
                
                ) */

            /*  replyService.getList(
                   {bno:bnoValue, page:1}, function(list){
                      
                      for(var i = 0, len = list.length||0; i<len; i++){
                         console.log(list[i]);
               
                      } */

            //replyService의 delete() 테스트
            /*         replyService.remove(14, function(count){
             console.log(count);
            
             if(count === "success"){
             alert("REMOVED");
             }
            
             }, function(err){
             alert('ERROR...');
            
             } */

            //replyupdate 22번 댓글 수정 테스트
            /*     replyService.update({ rno:2, bno:bnoValue,reply:"Modified Reply..."},function(result){
                   alert("수정 완료...");
            });     */

            //replyget 테스트
            /*     replyService.get(10, function(data){
                   console.log(data);
                }); */
         </script>

<script type="text/javascript">
   $(function(){
      var operForm = $("#operForm");
      
      $("button[data-oper='modify']").on("click", function(e){
         operForm.attr("action", "/board/modify");
      });
      
      $("button[data-oper='list']").on("click", function(e){
         operForm.find("#bno").remove();
         operForm.attr("action", "/board/list");
         operForm.submit();
      });
   });
</script>

<%@include file="../includes/footer.jsp"%>