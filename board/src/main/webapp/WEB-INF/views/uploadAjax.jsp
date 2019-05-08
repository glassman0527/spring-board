<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script>
	var regex = /(.*?)\.(exe|sh|js)$/i;
	var maxSize = 1024 * 1024 * 5;
	
	function checkExtension(fileName, fileSize) {
		if (fileSize >= maxSize) {
			alert("파일 사이즈 초과");
			return false;
		}
		
		if (regex.test(fileName)) {
			alert("해당종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}

	$(function() {
		var uploadDivCloneObj = $('.uploadDiv').clone(true);
		$('.uploadDiv').on("change", "input:file", function() {
			var files = $("#files").get(0).files;
			if(files.length < 1) {
				$('.uploadDiv span').text("파일첨부");
			} else if (files.length == 1) {
				$('.uploadDiv span').text(files[0].name);
			} else {
				$('.uploadDiv span').text(files.length + "files");
			}
		});
		
		$("#btn").click(function() {
			
			var formData = new FormData();
			var files = $("#files").get(0).files;
			
			for(var i in files) {
				if (!checkExtension(files[i].name, files[i].size)) return false;
				formData.append("uploadFile", files[i]);
			}
			console.log(formData);
			console.log(formData.uploadFile);
			
			$.ajax({
				url: 'uploadAjax',
				type: 'post',
				data: formData,
				dataType: 'json',
				processData: false,
				contentType: false,
				success: function(result) {
					console.log(result);
					
					$('.uploadDiv').html(uploadDivCloneObj.html());
				}
			});
		})
	})
</script>
<style>
	.uploadDiv span {display: inline-block; padding: 10px; background: #eee; cursor: pointer; border: 1px solid;}
	.uploadDiv input[type='file'] {display: none;}
</style>
</head>
<body>
<div class="uploadDiv">
	<label>
		<input type="file" name="uploadFile" multiple="multiple" id="files">
		<span>파일 첨부</span>
	</label>
</div>
<button id="btn">Submit</button>
</body>
</html>