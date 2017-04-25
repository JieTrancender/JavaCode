<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/4/24
  Time: 21:18
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
	<title>Login | JTrancender's Blog</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/styles.css">
	<link rel="stylesheet" href="../css/login.css">
	<link rel="stylesheet" href="../css/footer.css">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<%--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]--%>
</head>
<body>
	<%@ include file="_header.jsp"%>
	<c:if test="${requestScope.alertMsg != null}">
		<div class="container">
			<div class="alert alert-warning">${requestScope.alertMsg}</div>
		</div>
	</c:if>

	<div class="container">
		<form class="form-signin" role="form" action="<c:url value="/LoginServlet"/>" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input name="identifier" type="text" class="form-control" value="${requestScope.formInfo.identifier}" placeholder="Email/Phone/UserName" required autofocus>
			<input name="credentialDigest" type="password" class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div> <!-- /container -->
	<%@ include file="_footer.jsp"%>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
