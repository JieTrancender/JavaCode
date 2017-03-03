<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/3
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>JSTL提供的EL函数库</h1>

  <%--<%--%>
    <%--request.setAttribute("code", "<script>alert('hello');</script>");--%>
  <%--%>--%>
  <c:set var = "code" value = "<script>alert('hello');</script" scope="request"/>

  <%--${code}--%>
  <c:out value = "${code}" escapeXml="true" default="default value"/><br/>

  <c:url value = "/AServlet"/><br/>
  ${pageContext.request.contextPath}/AServlet

  <a href="<c:url value = '/index.jsp'/>">点击这里回到主页</a><br/>
  <c:url value = '/index.jsp'>
    <c:param name = "name" value="张三"/>
  </c:url>

  <c:if test = "${empty param.name}">
    你没有给出名为name的参数<br/>
  </c:if>

  <c:choose>
    <c:when test="${empty param.name}">你没有给出name的参数<br/></c:when>
    <c:when test="${empty param.name}">你没有给出name的参数<br/></c:when>
    <c:otherwise>你给出了name的参数，值为: <c:out value="${param.name}"/><br/> </c:otherwise>
  </c:choose>
  <br/>

  <%
    String[] strs = {"one", "two"};
    request.setAttribute("strs", strs);
  %>
  <c:forEach items="${strs}" var = "str">
    ${str}<br/>
  </c:forEach>

<%
  ArrayList<String> list = new ArrayList<String>();
  list.add("一");
  list.add("二");
  list.add("三");

  pageContext.setAttribute("list", list);
%>

<c:forEach items = "${list}" var = "ele" varStatus="vs">
  ${vs.index} ${vs.count} ${vs.first} ${vs.last} ${vs.current}<br/>
  ${ele}<br/>
</c:forEach>

  <%
    Date date = new Date();
    request.setAttribute("date", date);
  %>

  <fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>

  <%
    request.setAttribute("num1", 3.14159);
  %>

  <fmt:formatNumber value = "${requestScope.num1}" pattern="0.00"/>
  <fmt:formatNumber value = "${requestScope.num1}" pattern="#.##"/>
</body>
</html>
