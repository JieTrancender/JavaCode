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
  <script>
    function _change() {
        /**
         * 1. 得到元素
         * 2. 修改src为/VerifyHttpServlet
         */
        var imgEle = document.getElementById("verifyImage");
        imgEle.src = "/VerifyHttpServlet?a=" + new Date().getTime();
    }
  </script>
</head>
<body>
  <%-- 本页面提供登录表单，并且要显示错误信息 --%>
  <h1>登录</h1>

  <%
    /**
     * 读取名为userName的Cookie
     *   如果为空显示: ""
     *   如果不为空: Cookie的值
     */
    String userName = "";
    Cookie[] cookies = request.getCookies();//获取客户端Cookie
    if (null != cookies) {
        for (Cookie cookie : cookies) {
            if ("userName".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }
    }
  %>
  <%
    String message = "";
    String msg = (String) request.getAttribute("msg");
    if (null != msg) {
        message = msg;
    }
  %>
  <font color = "red">
    <b><%= message %></b>
  </font>
  <form action="/LoginHttpServlet" method="post">
    用户名: <input type="text" name = "userName" value = "<%= userName %>"><br/>
    密码: <input type="password" name = "password"><br/>
    验证码: <input type="text" name = "verifyCode" size = "3">
    <img id = "verifyImage" src="/VerifyHttpServlet" alt="/VerifyHttpServlert">
    <a href="javascript:_change();">换一张</a>
    <br/>
    <input type="submit" value = "登录">
  </form>
</body>
</html>
