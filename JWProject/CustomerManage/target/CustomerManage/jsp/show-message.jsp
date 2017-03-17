<%@ page import="org.jason.message.board.domain.Message" %><%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/17
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<h1>Show Message</h1>
	<%= request.getAttribute("msg").toString()%>
</body>
</html>
