<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/7
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>注册</h1>
  <%--<form action="<c:url value='/RegisterServlet'/></form>--%>
  <form action="${pageContext.request.contextPath}/RegisterServlet"method = "post">
    用户名: <input type="text" name = "userName"/><br/>
    密码: <input type="password" name="password"/><br/>
    <input type="submit" value = "注册">
  </form>
</body>
</html>
