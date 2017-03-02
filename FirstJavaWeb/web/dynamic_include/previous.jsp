<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>previous.jsp</h1>
  //动态包含
  <jsp:include page="next.jsp"/>

  //类似request.getReust......
  <jsp:forward page="next.jsp">
    <jsp:param name="userName" value="Jason"/>
    <jsp:param name="password" value="ShaoJie@qq.com"/>
  </jsp:forward>
</body>
</html>
