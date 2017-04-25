<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/4/24
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="#">
	<%--<title>Home | JTrancender's Blog</title>--%>
	<%--<link rel="stylesheet" href="../css/bootstrap.min.css">--%>
	<%--<link rel="stylesheet" href="../css/styles.css">--%>
	<%--<link rel="stylesheet" href="../css/login.css">--%>
</head>
<body>
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">JTrancender</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Contact</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Aomething else here</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Default</a></li>
				<li>
					<c:choose>
						<c:when test="${sessionScope.current.name != null}">
							<a href="#">${sessionScope.current.name}</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/jsp/login.jsp"/>">登录</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${sessionScope.current.name != null}">
							<a href="<c:url value="/LoginServlet"/> ">注销</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/jsp/register.jsp"/>">注册</a>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
	</div>
</nav>
</body>
</html>
