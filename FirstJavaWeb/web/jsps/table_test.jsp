<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/2
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <table border = "1px;" align = "center" style = "border: 1px solid gray;width: 60%; text-align: center;">
    <tr>
      <th>姓名</th>
      <th>年龄</th>
    </tr>
    <%
      for (int i = 0; i < 10; ++i) {
    %>
    <tr>
      <td>Jason</td>
      <td>21</td>
    </tr>
    <%
      }
    %>
  </table>
</body>
</html>
