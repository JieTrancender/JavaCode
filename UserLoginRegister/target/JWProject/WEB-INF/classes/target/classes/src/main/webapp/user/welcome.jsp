<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/7
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <%--<%--%>
    <%--String userName = (String) session.getAttribute("userName");--%>
    <%--if (null == userName) {--%>
      <%--/**--%>
       <%--* 发送响应体--%>
       <%--*/--%>
<%----%>
      <%--PrintWriter writer = response.getWriter();--%>
      <%--writer.println("你还没有登录，3秒钟后自动跳转到登录页！");--%>
      <%--response.setHeader("Refresh", "3;URL=/user/login.jsp");--%>
      <%--return;--%>
    <%--}--%>
  <%--%>--%>
  <h1>欢迎登录本系统</h1>
  <c:choose>
    <c:when test="empty ${sessionScope.sessionUser}">
      你还没有登录，<a href="<c:url value="/user/login.jsp"/> ">点击这里登录</a>
    </c:when>
    <c:otherwise>
      ${sessionScope.sessionUser},欢迎进入本系统!
    </c:otherwise>
  </c:choose>

  <%--<p><%= session.getAttribute("userName")%>, welcome to the web page.</p>--%>
</body>
</html>
