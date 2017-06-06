<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" href="">
</head>
<body>
Welcome<input type="text" name="" id="text">
<input type="button" onclick="send()" value="发送消息">
<input type="button" onclick="closeWebSocket()" value="关闭连接">
<div id="message"></div>

<script>
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/web-socket/web-socket");
    } else {
        alert("当前浏览器不支持WebSocket");
    }

    websocket.onerror = function() {
        setMessageInnerHTML("WebSocket连接错误");
    }

    websocket.onopen = function() {
        setMessageInnerHTML("WebSocket连接成功");
    }

    websocket.onmessage = function(event) {
        setMessageInnerHTML(event.data);
    }

    websocket.onclose = function() {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    window.onbeforeunload = function() {
        closeWebSocket();
    }

    function setMessageInnerHTML(innerHTML) {
        document.getElementById("message").innerHTML += innerHTML + '<br/>';
    }

    function closeWebSocket() {
        websocket.close();
    }

    function send() {
        var message = document.getElementById("text").value;
        websocket.send(message);
    }
</script>

</body>
</html>