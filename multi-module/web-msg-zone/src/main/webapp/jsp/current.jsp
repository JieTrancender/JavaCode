<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/6/23
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<p><%= request.getSession().getAttribute("current").toString()%></p>
</body>
</html>
