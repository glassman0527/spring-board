/**
 * 
 */

console.log("Reply Module...")

var replyService = (function(){
	//댓글 등록 기능
	function add(reply, callback, error) {
		console.log("add reply...");
		
		$.post({
			url : "/replies/new",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8"
		})
		.done(function(data) {
			if(callback) {
				callback(data);
			}
		})
		.fail(function(xhr, status, er) {
			if(error) {
				error(er)
			}
		});
	};
	
	//댓글 목록 기능
	function getList(param, callback, error) {
		console.log("getList reply...");
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/replies/" + bno + "/" + page)
		.done(function(data) {
			if(callback) {
				callback(data);
			}
		})
		.fail(function(xhr, status, er) {
			if(error) {
				error(er)
			}
		});
	}
	
	//댓글 삭제 기능
	function remove(rno, callback, error) {
		console.log("remove reply...");
		$.ajax("/replies/" + rno, {
			type : 'delete'
		})
		.done(function(data) {
			if(callback) {
				callback(data);
			}
		})
		.fail(function(xhr, status, er) {
			if(error) {
				error(er)
			}
		});
	}
	
	//댓글 수정 기능
	function modify(reply, callback, error) {
		console.log("modify reply...");
		
		$.ajax({
			url : "/replies/" + reply.rno,
			type : 'put',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8"
		})
		.done(function(data) {
			if(callback) {
				callback(data);
			}
		})
		.fail(function(xhr, status, er) {
			if(error) {
				error(er)
			}
		});
	};
	
	//댓글 상세조회 기능
	function get(rno, callback, error) {
		console.log("get reply...");
		
		$.ajax({
			url : "/replies/" + rno,
			type : 'get',
			dataType : 'json'
		})
		.done(function(data) {
			if(callback) {
				callback(data);
			}
		})
		.fail(function(xhr, status, er) {
			if(error) {
				error(er)
			}
		});
	};
	
	function displayTime(timeValue) {
		var today = new Date();
		
		var gap = today.getTime() - timeValue; // 현재 시간과 파라미터 값의 차이 return type = ms
		
		var dateObj = new Date(timeValue);
		var str = "";
		
		if (gap < 1000 * 60 * 60 * 24) {
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return leadZero(hh) + ':' + leadZero(mi) + ':' + leadZero(ss); 
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1; // getMonth() is zero based
			var dd = dateObj.getDate();
			
			return yy + '/' + leadZero(mm) + '/' + leadZero(dd);
		}
	}
	
	function leadZero(number) {
		return number > 9 ? number : '0' + number;
	}
	
	return {
		add:add,
		getList:getList,
		modify:modify,
		remove:remove,
		get:get,
		displayTime:displayTime
	}
}());
