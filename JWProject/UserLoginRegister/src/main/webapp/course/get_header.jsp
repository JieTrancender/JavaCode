<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/10
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body style="padding: 50px 0 0 150px;">
  <%--<h1>This is get_header.jsp</h1>--%>
  <c:forEach items="${requestScope.headerNames}" var="str">
    <%--${items}${str}--%>
  </c:forEach>
  <%
    Enumeration headers = request.getHeaderNames();
    while (headers.hasMoreElements()) {
        String header = (String) headers.nextElement();
  %>
  <%= header%>: <p style="font-weight:bold; display: inline-block;"><%= request.getHeader(header)%></p><br/>
  <%
    }
  %>
</body>
</html>
