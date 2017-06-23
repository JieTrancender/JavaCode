<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/5/9
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="#">
	<title>Ip Table | JTrancender's Blog</title>
	<link rel="stylesheet" href="../vendor/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/styles.css">
	<link rel="stylesheet" href="../css/ip-table.css">
</head>
<body>
	<%@ include file="_header.jsp"%>

	<div class="iptable">
		<c:forEach items="${applicationScope.ipContextMap}" var="ipSet">
			<p>${ipSet.key} = ${ipSet.value}</p>
		</c:forEach>
	</div>

	<%@ include file="_footer.jsp"%>
</body>
</html>
