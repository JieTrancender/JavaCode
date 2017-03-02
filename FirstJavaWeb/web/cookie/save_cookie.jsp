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
  <h1>保存Cookie</h1>
  <%-- request、response、session、application、pageContext、config、out、page、exception --%>

  <%
    Cookie cookie1 = new Cookie("userName", "Jason");
    cookie1.setMaxAge(60 * 60 * 60);
    cookie1.setPath("/");
//    cookie1.setDomain(".baidu.com");
    response.addCookie(cookie1);

    Cookie cookie2 = new Cookie("password", "ShaoJie@qq.com");
    cookie2.setMaxAge(60 * 60);
//    cookie2.setMaxAge(0);  //删除Cookie
    response.addCookie(cookie2);
  %>
</body>
</html>
