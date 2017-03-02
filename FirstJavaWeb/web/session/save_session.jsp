<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>向session域保存数据</h1>
  <%
//    request.getSession() //jsp自动创建Session
    session.setAttribute("userName", "Jason");
    session.setAttribute("password", "ShaoJie@qq.com");
  %>
</body>
</html>
