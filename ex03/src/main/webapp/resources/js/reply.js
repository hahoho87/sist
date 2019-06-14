
 console.log("Reply Module.....");
 
 var replyService = ( function (){

    function add(reply, callback, error) {
        console.log("add reply........");

        $.ajax({
            type : 'post',
            url : '/replies/new',
            data : JSON.stringify(reply),
            contentType : "application/json; charset=utf-8",
            //성공이면 (RequestEntity 200이 넘어오면)
            success : function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            //에러이면 (RequestEntity 에러가 넘어오면)
            error : function(xhr, stataus, er) {
                if(error) {
                    error(er);
                }
            }
        });
    }
    
    function getList(param, callback, error) {
        
    	var bno = param.bno;
    	var page = param.page || 1;	//페이지번호가 없으면 1로 처리

        $.getJSON("/replies/pages/" + bno + "/" + page + ".json",
        		function(data) {
        	if(callback) {
        		callback(data);
        	}
        	
        }).fail(function(xhr, status, err) {
        	if (error) {
        		error();
        	}
        });
    }//end getList
    
//    function remove(rno, callback, error) {
//    	$.ajax({
//    		type : 'delete',
//    		url : '/replies/' + rno,
//    		success : function(deleteResult, status, xhr) {
//    			if(callback) {
//    				callback(deleteResult);
//    			}
//    		},
//    		error : function(xhr, status, er) {
//    			if(error){
//    				error(er);
//    			}
//    		}
//    	});
//    }//end remove
    
     return {
    	 add : add,
    	 getList : getList,
    	 remove : remove
     };
     //앞의 add는 이름, 뒤의 add는 함수
 })();