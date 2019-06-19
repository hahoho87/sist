console.log("Reply module .... reply.js");

var replyService = ( function(){
	
	//댓글 등록
	function add(reply, callback, error){
		console.log("reply.js - add()");
		$.ajax({
			type : 'post',
			url :'/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}//END add()
	
	//댓글 목록 가져오기
	function getList(param, callback, error){
		console.log("reply.js - getList()");
		var bno = param.bno;
		var page = param.page || 1;	//페이지 번호가 없을 때는 1로 처리

		$.getJSON(
			"/replies/pages/" + bno + "/" + page + ".json",
			function(data){
//				if(callback){ callback(data); }
				if(callback){ 
					//댓글 개수 + 목록
					callback(data.replyCnt, data.list);  
				}
			}
		).fail(
			function(xhr, status, er){
				if(error){ 	error(er); }
		    }
		);
	}//END getList()

	//댓글 삭제 
	function remove(rno, callback, error){
		console.log("reply.js - remove()");
		$.ajax({
			type : 'delete',
			url :'/replies/' + rno,
			success : function(result, status, xhr){
				if(callback){ callback(result);	}
			},
			error : function(xhr, status, er){
				if(error){ 	error(er);	}
			}
		})
	}//END remove()
	
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
			error : function(xhr, status, er){
				if(error){ 	error(er);	}
			}
		})
	}//END update()
	 
	//댓글 하나 가져오기
	function get(rno, callback, error){
		console.log("reply.js - get()");
		$.get(
			"/replies/" + rno + ".json",
			function(result){
				if(callback){ callback(result); }
			}
		).fail(
			function(xhr, status, er){
				if(error){ 	error(er); }
		    }
		);
	}//END get()
	
	return { get: get,
			 update: update,
			 add : add,
			 getList : getList, 
			 remove : remove };
})(); 












