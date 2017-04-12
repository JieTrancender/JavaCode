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
	<title>Register</title>
	<script src="<c:url value="../js/verify_code.js"/> "></script>
</head>
<body>
	<h1>注册页面</h1>
	<form action="<c:url value="/RegisterUser"/> " method="post">
		用户名: <input type="text" name="name" value="${userInfo.name}"/>${errorss.name}
	</form>
</body>
</html>
