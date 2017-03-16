<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/16
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<%--它的作用是为本页面所有的表单和超链接指定显示内容的框架--%>
	<base target="main">
	<title>Title</title>
</head>
<body style="text-align:center;">
	<h1>客户关系管理系统</h1>
	<a href="<c:url value="/add.jsp"/>">添加客户</a>
	<a href="<c:url value="/list.jsp"/> ">查询客户</a>
	<a href="<c:url value="/query.jsp"/>">高级搜索</a>
</bodyi>
</html>
