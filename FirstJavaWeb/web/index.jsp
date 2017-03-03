<%--
  Created by IntelliJ IDEA.
  User: 58286
  Date: 2017/2/27
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%--jsp指令，也是一种特殊的标签--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ja" uri="/WEB-INF/tlds/jason-tag.tld"%>
<%--<%@ taglib prefix="js" uri="/WEB-INF/tlds/jason-tag.tld" %>--%>

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
  <br/>
  <h1><ja:MyTag/></h1><br/>
  <h1><ja:MySimpleTagSupport/></h1>
  <hr/>

  <%
    request.setAttribute("xxx", "zhangSan");
  %>

  <h3>
    <ja:MySecondSimpleTagSupport>
      ${xxx}<br/>
    </ja:MySecondSimpleTagSupport>
    <br/>
    <ja:MySecondSimpleTagSupport>
      我是JTrancender<br/>
    </ja:MySecondSimpleTagSupport>
    <h1>这下面的内容都显示不出来的</h1>
  </h3>
  </body>
</html>
