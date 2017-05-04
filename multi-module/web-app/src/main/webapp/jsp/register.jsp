<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/4/12
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<%--<meta charset="utf-8">--%>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="#">
	<title>Register | JTrancender's Blog</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/styles.css">
	<link rel="stylesheet" href="../css/register.css">
	<link rel="stylesheet" href="../css/footer.css">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<%--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]--%>
</head>
<body>
	<%@ include file="_header.jsp"%>
	<%--<h1>注册页面</h1>--%>
	<c:if test="${requestScope.alertMsg != null}">
		<div class="container">
			<div class="alert alert-warning">${requestScope.alertMsg}</div>
		</div>
	</c:if>
	<form class="form-register" action="<c:url value="/RegisterServlet"/> " method="post">
		<h2 class="form-register-heading">Please Register</h2>
		<input type="text" name="name" class="form-control" value="${userInfo.name}" placeholder="User Name"/>
		<input type="text" name="avatar" class="form-control" value="${userInfo.avatar}" placeholder="Avatar Address"/>
		<input type="text" name="gender" class="form-control" value="${userInfo.gender}" placeholder="Gender"/>
		<input type="email" name="identifier" class="form-control" placeholder="Email/Phone/Id"/>
		<input type="password" name="password" class="form-control" placeholder="Password"/>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
	</form>
	<%@ include file="_footer.jsp"%>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
