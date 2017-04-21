<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>MessageBoard</title>
	<link rel="stylesheet" href="./css/styles.css">
</head>
<body>
	<div id="header"></div>

	<div id="content" style="margin:50px 0 0 600px; font-size:34px; line-height:34px;">
		<a href="<c:url value="/jsp/add-message.jsp"/>">Add Message</a><br/>
		<a href="<c:url value="/AddServlet"/> ">Show Messages</a><br/>
	</div>
	<div id="footer"></div>

	<script src="./js/vendor/jquery/jquery.min.js"></script>
	<script src="./js/message-board.js"></script>
</body>
</html>
