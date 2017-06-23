<%@ page import="jason.common.tools.CommonUtils" %>
<%@ page import="jason.user.service.UserService" %>
<%@ page import="jason.user.domain.User" %>
<%@ page import="jason.user.service.UserException" %><%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/4/24
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="#">
	<title>Login | JTrancender's Blog</title>
	<link rel="stylesheet" href="<c:url value="/vendor/css/bootstrap.min.css"/> ">
	<script src="<c:url value="/vendor/js/jquery.min.js"/> "></script>
	<script src="<c:url value="/vendor/js/bootstrap.min.js"/> "></script>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<%--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]--%>
	<style>
		.login-container {
			margin-top:60px;
		}

		.login-form {
			margin:0 auto;
			width:600px;
		}
	</style>
</head>
<body>
	<%@ include file="_header.jsp"%>

	<%
		UserService userService = new UserService();
		String userIdDigest = null;
		String rememberMeDigest = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
		    if (cookie.getName().equalsIgnoreCase("userIdDigest")) {
		        userIdDigest = cookie.getValue();
				} else if (cookie.getName().equalsIgnoreCase("rememberMeDigest")) {
		        rememberMeDigest = cookie.getValue();
				} else {
		        continue;
				}
		}

		if (userIdDigest != null && rememberMeDigest != null) {
			try {
				User user = userService.readUserAuth(userIdDigest, rememberMeDigest);
				System.out.println("login.jsp" + user.toString());
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("current", user);
				response.sendRedirect("/zone/index.jsp");
			} catch (UserException e) {
//				throw new RuntimeException(e);
				CommonUtils.removeCookie(request, response, "userIdDigest");
				CommonUtils.removeCookie(request, response, "rememberMeDigest");
			}
		}
	%>

	<div class="container login-container">
		<c:if test="${requestScope.alertMsg != null}">
			<div class="alert alert-warning">${requestScope.alertMsg}</div>
		</c:if>
		<div class="login-form">
			<form class="form-signin" role="form" action="<c:url value="/LoginServlet"/>" method="post">
				<h2 class="form-signin-heading">Please sign in</h2>
				<input name="identifier" type="text" class="form-control" value="${cookie['identifier'].value}" placeholder="Email/Phone/UserName" required autofocus>
				<input name="password" type="password" class="form-control" value="${cookie['password'].value}" placeholder="Password" required>
				<div class="checkbox">
					<label>
						<input id="remember_me" name="remember_me" type="checkbox"> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>
	</div>

	<%--<%@ include file="_footer.jsp"%>--%>

	<script src="<c:url value="/vendor/js/jquery.min.js"/> "></script>
	<script src="<c:url value="/vendor/js/bootstrap.min.js"/> "></script>
</body>
</html>
