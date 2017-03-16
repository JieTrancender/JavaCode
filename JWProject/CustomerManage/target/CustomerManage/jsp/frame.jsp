<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/16
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Index</title>
	<script src="../js/jquery.min.js"></script>
	<script>
		$(function(){
		    $("#top").load("/jsp/top.jsp");
		    $("#welcome").load("/jsp/welcome.jsp");
		});
	</script>
</head>
<body>
	<div id="top" style="height:20%; text-align:center;"></div>
	<div id="welcome" style="height:80%;"></div>
</body>
</html>
