<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Board Register</title>

  <!-- Custom fonts for this template -->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  <style type="text/css">
  	.chat li { cursor: pointer; }
  </style>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
  
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">
      
		<!-- Topbar -->
      	<jsp:include page="../includes/header.jsp"/>
		<!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
		  <div class="row">
              <div class="col-lg-12">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h3 text-gray-900 mb-4">Board View</h1>
                  </div>
                  <form class="user" method="post">
                  	Title
                    <div class="form-group">
                      <input name="title" value="${board.title}" type="text" class="form-control" placeholder="제목을 입력하세요" readonly="readonly">
                    </div>
                    TextArea
                    <div class="form-group">
                    	<textarea name="content" rows="10" cols="" class="form-control" placeholder="내용을 입력하세요" readonly="readonly">${board.content}</textarea>
                    </div>
                    Writer
                    <div class="form-group">
                      <input name="writer" value="${board.writer}" type="text" class="form-control" placeholder="작성자를 입력하세요" readonly="readonly">
                    </div>
                    <div class="form-group">
                    	<a href="modify${cri.listLink}&bno=${board.bno}" class="btn btn-danger btn-block">글 수정</a>
                    	<a href="list${cri.listLink}" class="btn btn-primary btn-block">글 목록</a>
                    </div>
                  </form>
                </div>
              </div>
		  </div>
			<div class="row">
				<div class="col-lg-12">
					<div class="p-5">
						<div class="m-2 clearfix">
							<i class="fa fa-comments fa-fw"></i> Reply
							<button id="addReplyBtn" class="btn btn-primary btn-sm float-right">New Reply</button>
						</div>
						<ul class="list-group chat">
				<!-- 			<li class="list-group-item">
								<div class="header">
									<strong class="primary-font">user00</strong>
									<small class="float-right text-muted">2019-05-01 13:00</small>
								</div>
								<p class="m-0">내용내용</p>
							</li>
							<li class="list-group-item clearfix left">
								<div class="header">
									<strong class="primary-font">user00</strong>
									<small class="float-right text-muted">2019-05-01 13:00</small>
								</div>
								<p class="m-0">내용내용</p>
							</li> -->
						</ul>
					</div>
				</div>
			</div>
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
	  <!-- Footer -->
	  <jsp:include page="../includes/footer.jsp"/>
	  <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Reply Modal</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">
			<div class="form-group">
				<label for="reply">Reply</label><input class="form-control" id="reply" name="reply">
			</div>        
			<div class="form-group">
				<label for="replyer">Replyer</label><input class="form-control" name="replyer" id="replyer">
			</div>        
			<div class="form-group">
				<label for="replydate">Replydate</label><input class="form-control" name="replydate" id="replydate">
			</div>        
        </div>
        <div class="modal-footer">
          <button class="btn btn-warning" type="button" data-dismiss="modal" id="modalModBtn">Modify</button>
          <button class="btn btn-danger" type="button" data-dismiss="modal" id="modalRmBtn">Remove</button>
          <button class="btn btn-primary" type="button" data-dismiss="modal" id="modalRegBtn">Register</button>
          <button class="btn btn-secondary" type="button" data-dismiss="modal" id="modalCloseBtn">Close</button>
          <!-- <a class="btn btn-primary" href="login.html">Logout</a> -->
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="/resources/js/demo/datatables-demo.js"></script>
  <script src="/resources/js/reply.js"></script>
  <script>
  	var bno = '${board.bno}';
  	showList();
  	function showList(page) {
  		replyService.getList({bno:bno, page:page||1}, function(list) {
  			var str = "";
  			if(list == null || list.length == 0) {
  				$('.chat').html("");	
  				return;
  			}
  			
  			for(var i in list) {
  				str += "<li class='list-group-item' data-rno='" + list[i].rno + "'>" 
  				str += "<div class='header'>"
  				str += "<strong class='primary-font'>" + list[i].replyer + "</strong>" 
  				str += "<small class='float-right text-muted'>" + replyService.displayTime(list[i].replyDate) + "</small>" 
  				str += "</div>"
  				str += "<p class='m-0'>" + list[i].reply + "</p>" 
  				str += "</li>"
  			}
  			$(".chat").html(str);
  		});
  	}
  	// modal
  	var modal = $("#myModal"); 
  	var modalInputReply = modal.find("[name='reply']");
  	var modalInputReplyer = modal.find("[name='replyer']");
  	var modalInputReplyDate = modal.find("[name='replydate']");
  	
  	var modalModBtn = $("#modalModBtn");
  	var modalRmBtn = $("#modalRmBtn");
  	var modalRegBtn = $("#modalRegBtn");
  	
  	$("#addReplyBtn").click(function() {
  		modal.find("input").val("");
  		modalInputReplyDate.parent().hide();
  		modalInputReplyer.prop("readonly", false);
  		modal.find("button[id != 'modalCloseBtn']").hide();
  		modalRegBtn.show();
  		modal.modal("show");
  	})
  	
  	modalRegBtn.click(function() {
  		replyService.add({
  	  		reply : modalInputReply.val(),
  	  		replyer : modalInputReplyer.val(),
  	  		bno : bno
  	  	}, function(result) {
  	  		alert(result);
  	  		modal.find("input").val("");
  	  		modal.modal("hide");
  	  		showList();
  	  	});
  	})
  	
  	$(".chat").on("click", "li", function(e) {
  		var rno = $(this).data("rno");
  		
  		replyService.get(rno, function(result) {
  			modalInputReply.val(result.reply);
			modalInputReplyer.val(result.replyer).prop("readonly", true);
			modalInputReplyDate.val(replyService.displayTime(result.replyDate)).prop("readonly", true).parent().show();
			console.log(result);
			
  			modal.data("rno", result.rno);
  			modal.find("button[id != 'modalCloseBtn']").hide();
  			modalModBtn.show();
  			modalRmBtn.show();
  			modal.modal("show");
  		});
  	})
  	
  	modalModBtn.click(function() {
  		replyService.modify({
  	  		reply : modalInputReply.val(),
  	  		rno : modal.data("rno")
  	  	}, function(result) {
  	  		alert(result);
  	  		modal.modal("hide");
  	  		showList();
  	  	});
  	})
  	
  	modalRmBtn.click(function() {
  		replyService.remove(modal.data("rno"), function(result) {
  			console.log(modal.data("rno"));
  	  		alert(result);
  	  		modal.modal("hide");
  	  		showList();
  	  	});
  	})
  	/* replyService.add({
  		reply : 'js Reply',
  		replyer : 'tester',
  		bno : bno
  	}, function(result) {
  		alert(result);
  	}); */
  	/* replyService.getList({
  		bno : bno,
  	}, function(result) {
  		console.log(result);
  	}); */
/*   	replyService.modify({
		reply : 'js Reply modified',
		rno : 35
	}, function(result) {
		alert(result);
	}); */
  /* 	replyService.get(35, function(result) {
  		console.log(result);
  	}); */
  </script>
</body>

</html>
