<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" href="">
	<script src="./js/vendor/jquery/jquery.min.js"></script>
	<script>
		function loadSuccess() {
		    alert("loadSuccess");
		}

		$(function() {
//		    alert("Hello World!");
				$.ajax({
				    type: "get",
						async: "true",
						url: "http://localhost:8080/json/user-json",
						dataType: "jsonp",
						jsonp: "jsoncallback",
						jsonCallback: "....",
						success: function (data) {
								$('#userId').html(data['userId']);
            }
				});
		});
	</script>
</head>
<body>
	<p>userId: <span id="userId"></span></p>
	<p>identityType: <span id="identityType"></span></p>
	<p>identifier: <span id="identifier"></span></p>
	<p>credentialDigest: <span id="credentialDigest"></span></p>
	<p>rememberMeDigest: <span id="rememberMeDigest"></span></p>
	<button id="button">获取信息</button>
	<p id="data"></p>
</body>
</html>
