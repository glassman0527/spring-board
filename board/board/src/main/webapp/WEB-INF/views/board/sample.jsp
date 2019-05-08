<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>RSS</title>
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn").click(function() {
			$.ajax({
				url: 'proxy',
				success: function(data, status, xhr) {
					console.log(data);
					console.log(status);
					console.log(xhr);
					
					$(data).find("item").each(function() {
						$("body").append("<h2>" + $(this).find("title").text());
					});
				},
				error: function(xhr, status, errorThrown) {
					console.log(xhr);
					console.log(status);
					console.log(errorThrown);
				}
			})
		})
	})
</script>
</head>
<body>
<h1>RSS 연습</h1>
<button id="btn">RSS Go!</button>
</body>
</html>