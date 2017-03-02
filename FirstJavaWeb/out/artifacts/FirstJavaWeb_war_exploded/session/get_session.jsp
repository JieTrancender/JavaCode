<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>获取Session中的数据</h1>
  <%
    String session1 = (String)session.getAttribute("userName");
  %>
  <%= session1 %>
</body>
</html>
