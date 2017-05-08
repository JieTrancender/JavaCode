<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="#">
	<title>Index | JTrancender's Blog</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/styles.css">
	<link rel="stylesheet" href="./css/login.css">
	<link rel="stylesheet" href="./css/footer.css">
</head>
<body>
	<%@ include file="/jsp/_header.jsp"%>
	<h1>Hi, ${sessionScope.current.name} welcome to here.</h1>
<%--<h2>Hello World!</h2>--%>
<p><c:out value="${cookie['Compiler'].value}"/></p>
	<%--<p>Size = ${applicationScope.get("ipContextMap").size}</p>--%>
	<p>${applicationScope.ipContextMap}</p>
	<p>Size = <c:out value="${fn:length(applicationScope.ipContextMap)}"></c:out> </p>
	<%@ include file="/jsp/_footer.jsp"%>

	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>
