<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>about.jsp</h1>
<%
  String userName = (String)session.getAttribute("userName");
  if (null == userName) {
    /**
     * 向request域中保存错误信息，转发到login.jsp
     */
    request.setAttribute("msg", "你还没有登录，请登录！");
    request.getRequestDispatcher("/session/login.jsp").forward(request, response);
  }
%>
<p><%= session.getAttribute("userName")%>, welcome to the web page.</p>
</body>
</html>
