<%@ page import="org.jason.user.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/7
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Title</title>
  <script src="<c:url value="/js/login-register.js"/> "></script>
  <%--<script>--%>
    <%--function _change() {--%>
        <%--/**--%>
         <%--* Function: 变换验证码--%>
         <%--* Note: 参数通过获取最新的时间已达到不同--%>
         <%--*/--%>
        <%--var img = document.getElementById("verifyImage");--%>
        <%--img.src = "/VerifyServlet?a=" + new Date().getTime();--%>
    <%--}--%>
<%--//  </script>--%>
</head>
<body>
  <h1>登录页面</h1>

  <%

    /**
     * 读取名为userName的Cookie，如果为空显示: ""，如果不为空，显示Cookie的值
     */
    String userName = "";
    Cookie[] cookies = request.getCookies();
    if (null != cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("userName")) {
                userName = cookie.getValue();
                break;
            }
        }
    }

    /**
     * 读取request域中的数据信息作为发生错误时回退原页面的数据
     * 不使用EL表达式的原因是直接登录时读取cookie值
     */
    String password = "";
    User userInfo = (User) request.getAttribute("userInfo");
    if (null != userInfo) {
      userName = userInfo.getUserName();
      password = userInfo.getPassword();
    }
  %>

  <div>
    <p style = "color:red;">${requestScope.msg}</p>
  </div>
  <form action="<c:url value="/LoginServlet"/>" method="post">
    <p>用户名: <input type="text" name="userName" value="<%= userName %>"></p>
    <p>密码: <input type="password" name="password" value="<%= password %>"></p>
    <p>
      验证码: <input type="text" name="verifyCode" size="3">
      <img id="verifyImage" src="<c:url value="/VerifyServlet"/> " alt="/VerifyHttpServlet">
      <a href="javascript:_change('verifyImage');">换一张</a>
    </p>
    <input type="submit" value = "Submit"/>
    <a href="<c:url value="/user/register.jsp"/>">注册</a>
  </form>
</body>
</html>
