<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<html>
<body>
<h2>Hello World!</h2>
<a href="<c:url value='/HttpHeaderServlet'/>">Get Http Header</a><br/>
<a href="<c:url value="/user/login.jsp"/>">Go To Login</a><br/>
<a href="<c:url value="/user/register.jsp"/>">Go to Register</a><br/>
</body>
</html>
