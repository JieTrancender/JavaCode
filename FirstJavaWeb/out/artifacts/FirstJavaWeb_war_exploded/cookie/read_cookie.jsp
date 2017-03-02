<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>获取Cookie</h1>
  <%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            out.print(c.getName() + "=" + c.getValue() + "<br/>");
        }
    }
  %>
</body>
</html>
