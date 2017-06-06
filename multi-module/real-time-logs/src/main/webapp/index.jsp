<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>tail log</title>
	<link rel="stylesheet" href="">
	<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
</head>
<body>
<div id="log-container" style="height:450px; overflow-y:scroll; background:#333; color:#aaa; padding:10px">
	<div></div>
</div>

<script>
    $(document).ready(function() {
        var websocket = new WebSocket("ws://localhost:8080/log-socket/log");
        websocket.onmessage = function(event) {
            $("#log-container div").append(event.data);
            // 滚动条滚动到最底部
            $("#log-container").scrollTop($("#log-container div").height() - $("log-container").height());
        };
    });
</script>
</body>
</html>