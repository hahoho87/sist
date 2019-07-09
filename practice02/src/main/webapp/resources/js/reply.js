console.log("Reply module .... reply.js");

var replyService = (function(){
	
	//add function
	function add(reply, callback, error){
		console.log("add reply......");
		
		$.ajax({
			type: 'post',
			url	: '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, err){
				if(error){
					callback(err);
				}
			}
		})
	}// End add
	
	//댓글 목록 가져오기
	function getList(param, callback, error){
		console.log("reply.js - getList()");
		var bno = param.bno;
		var page = param.page || 1;	//페이지 번호가 없을 때는 1로 처리

		$.getJSON(
			"/replies/pages/" + bno + "/" + page + ".json",
			function(data){
				if(callback){ 
					//댓글 목록만 가져오는 경우
					//callback(data); 
					//댓글 숫자와 목록을 가지고 오는 경우
					callback(data.replyCnt, data.list);
				}
			}
		).fail(
			function(xhr, status, err){
				if(error){ 	error(); }
		    }
		);
	}//END getList()
	
	//댓글 삭제
	function remove(rno, callback, error){
		$.ajax({
			type: 'delete',
			url : '/replies/' + rno,
			success : function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult)
				}
			},
			error : function(xhr, status, err){
				if(error){
					error(err);
				}
			}
		});
	}// End remove
	
	//댓글 하나 조회
	function get(rno, callback, error){
		$.get("/replies/" + rno + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error(err);
			}
		});
	}//End get
	
	//댓글 수정
	function update(reply, callback, error){
		console.log("reply.js - update()");
		console.log("rno : " + reply.rno);
		$.ajax({ 
			type : 'put',
			url :'/replies/' + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){ callback(result);	}
			},
			error : function(xhr, status, err){
				if(error){ 	error(err);	}
			}
		});
	}//END update()
	
	//댓글 시간 처리
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
	return {
			add : add,
			getList : getList,
			remove : remove,
			get : get,
			update : update,
			displayTime : displayTime
		   };
		   
		   
})();