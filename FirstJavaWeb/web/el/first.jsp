<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/3
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.jason.domain.*" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  Address address = new Address();
  address.setCity("北京");
  address.setStreet("西三");

  Employee employee = new Employee();
  employee.setName("Jason");
  employee.setSalary(1234);
  employee.setAddress(address);

  request.setAttribute("employee", employee);
%>

<h3>使用EL获取request域的employee</h3>
${requestScope.employee.address.street} <!-- request.getAttribute("employee").getAddress().getStreet() -->
${employee.haha}
${requestScope.employee.address.street} <!-- request.getAttribute("employee").getAddress().getStreet() -->
<br/>

<a href="${pageContext.request.contextPath}/index.jsp">点击这里</a><br/>
<form action="${pageContext.request.contextPath}/FifthServlet">
  <input type="submit" vlaue = "Submit">
</form>
</body>
</html>
