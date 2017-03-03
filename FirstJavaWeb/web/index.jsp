<%--
  Created by IntelliJ IDEA.
  User: 58286
  Date: 2017/2/27
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%--jsp指令，也是一种特殊的标签--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--java代码片段--%>
<%
  String path = request.getContextPath();
/**
 * http://localhost:8080/welcome/
 */
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
  <head>
    <%--向页面输出basePath--%>
      <base href="<%=basePath%>">
    <title>My first web project</title>
  </head>
  <body>
    Hello World!
    Succeed to run the first web!!
    <a href="./login.html" alt = "./login.html">Go to login.html</a>
    <br>
    <a href="../src/test.html" >Go to test.html</a>
    <br>
    <%
      int a = 10;
    %>

    <%
      out.print(a);
    %>
    <%=a%>
    <br/>
    <%!
      int a = 100;
      public void fun() {
          System.out.println(a);
      }
    %>
    <%
      out.print(this.a++);
      fun();
    %>

    <a href="/FirstHttpServlet">进入下载页面</a>

    ${header['User-Agent']};
  </body>
</html>
