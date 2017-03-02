<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<a href="/session/session.jsp;JSESSIONID=<%= session.getId() %>">点击这里</a>
<a href="/session/session.jsp;JSESSIONID=<%= session.getId() %>">点击这里</a>
<a href="/session/session.jsp;JSESSIONID=<%= session.getId() %>">点击这里</a>
<a href="/session/session.jsp;JSESSIONID=<%= session.getId() %>">点击这里</a>

<%
  //它会查看cooiek是否存在，如果不存在，在制定的rul后添加jsessioid
  out.println(response.encodeURL("/LoginHttpServlet"));
%>
</body>
</html>
