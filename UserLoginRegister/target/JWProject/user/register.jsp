<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/7
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<html>
<head>
  <title>Title</title>
</head>
<%
  String message = "";
  String msg = (String) request.getAttribute("msg");
  if (null != msg) {
      message = msg;
  }
%>
<body>
  <%--${requestScope.}--%>
  <h1>注册页面</h1>
  <%--<p style = "color: red; font-weight: 900;">${msg }</p>--%>
  <%--<p style="color:red;">${pageContext.request.getAttribut("msg")}</p>--%>
  <p style = "color: red; font-weight: bold;">
    <%= message %>
  </p>
  <%--<form action="${pageContext.request.contextPath}/../../RegisterServlet" method="post">--%>
  <%--<form action="<c:url value='/RegisterServlet'/>" method="post">--%>
  <form action="<c:url value="/RegisterServlet"/> " method="post">
    用户名: <input type="text" name="userName"/><br/>
    密  码: <input type="password" name="password"/><br/>
    <input type="submit" value="Submit"/>
  </form>
</body>
</html>
