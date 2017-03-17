<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Add Message</h1>
	<form action="/AddServlet" method="post">
		<p>
			<label for="userName">姓名</label>
			<input type="text" id="userName" name="userName"/>
		</p>
		<p>
			<label for="phone">电话</label>
			<input type="text" id="phone" name="phone">
		</p>
		<p>
			<label for="email">邮箱</label>
			<input type="text" id="email" name="email">
		</p>
		<p>
			<label for="title">主题</label>
			<input type="text" id="title" name="title">
		</p>
		<p>
			<label for="content">留言内容</label>
			<textarea name="content" id="content" cols="30" rows="10"></textarea>
		</p>
		<p>
			<input type="submit" value="Submit">
		</p>
	</form>
</body>
</html>
