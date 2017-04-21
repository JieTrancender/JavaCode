<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/23
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.jason.msg.board.domain.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<c:forEach items="${requestScope.msgList}" var="msg">
		${msg}<br/>
	</c:forEach>
	<ul>
		<li><a href="<c:url value="/index.jsp"/>">Go To Index</a></li>
		<li><a href="<c:url value="/jsp/add-message.jsp"/>">Go To Add Msg</a></li>
	</ul>
</body>
</html>
