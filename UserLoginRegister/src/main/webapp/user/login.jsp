<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/7
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Title</title>
  <script>
    function _change() {
        /**
         * Function: 变换验证码
         * Note: 参数通过获取最新的时间已达到不同
         */
        var img = document.getElementById("verifyImage");
        img.src = "/VerifyServlet?a=" + new Date().getTime();
    }
  </script>
</head>
<body>
  <h1>注册页面</h1>

  <%
    /**
     * 读取名为userName的Cookie，如果为空显示: ""，如果不为空，显示Cookie的值
     */
    String userName = "";
    Cookie[] cookies = request.getCookies();
    if (null != cookies) {
        for (Cookie cookie : cookies) {
            if ("userName".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }
    }

    /**
     * 错误信息提示块
     */
    String message = "";
    String msg = (String) request.getAttribute("msg");
    if (null != msg) {
        message = msg;
    }
  %>

  <div>
    <p style = "color:red;"><%= message %></p>
  </div>
  <form action="<c:url value="/LoginServlet"/>">
    <p>用户名: <input type="text" name="userName"></p>
    <p>密码: <input type="password" name="password"></p>
    <p>
      验证码: <input type="text" name="verifyCode" size="3">
      <img id="verifyImage" src="<c:url value="/VerifyServlet"/> " alt="/VerifyHttpServlet">
      <a href="javascript:_change();">换一张</a>
    </p>
    <input type="submit" value = "Submit"/>
  </form>
</body>
</html>
