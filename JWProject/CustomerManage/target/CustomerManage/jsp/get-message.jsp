<%@ page import="org.jason.message.board.domain.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>请输入需要查找留言的姓名</h1>
	<form action="/AddServlet" method="get">
		<p>
			<label for="name">姓名</label>
			<input type="text" name="userName">
		</p>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
