<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/4/12
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
	<script src="<c:url value="/js/login-register.js"/> "></script>
</head>
<body>
<h1>注册页面</h1>
<p style = "color: red; font-weight: bold;">
	${requestScope.msg}
</p>
<form action="<c:url value="/RegisterServlet"/> " method="post">
	用户名: <input type="text" name="userName" value="${userInfo.userName}"/>${errors.userName}<br/>
	密  码: <input type="password" name="password" value="${userInfo.password}"/>${errors.password}<br/>
	确认密码: <input type="password" name="verifyPassword" value="${userInfo.verifyPassword}"/>${errors.verifyPassword}<br/>
	年龄: <input type="text" name="age" value="${userInfo.age}"/>${errors.age}<br/>
	性别: <input type="text" name="gender" value="${userInfo.gender}"/>${errors.gender}<br/>
	验证码: <input type="text" name="verifyCode" value="${userInfo.verifyCode}" size="3">
	<img id="verifyImage" src="<c:url value="/VerifyServlet"/>" border="1" alt="">
	<a href="javascript:_change('verifyImage')">换一张</a>${errors.verifyCode}<br/>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>
