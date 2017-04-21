<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="../js/vendor/validation/validation-framework.js" type="text/javascript"></script>
	<script src="../UEditor/ueditor.config.js"></script>
	<script src="../UEditor/ueditor.all.js"></script>
	<link rel="stylesheet" href="../UEditor/themes/default/css/ueditor.css">

	<script type="text/javascript" charset="utf-8" src="../UEditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<h1>Add Message</h1>
	<form id="add-msg-form" action="/AddServlet" method="post" onsubmit="return doValidate(this)">
		<p>
			<label for="userName">姓名</label>
			<input type="text" id="userName" name="name"/>
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
			<textarea name="content" id="content" style="width:800px; height:400px;"></textarea>
			<script type="text/javascript">
				UE.getEditor("content");
			</script>
		</p>
		<p>
			<input type="submit" value="Submit">
		</p>
	</form>

	<ul>
		<li><a href="<c:url value="/index.jsp"/> ">Go To Index</a></li>
		<li><a href="<c:url value="/AddServlet"/>">Go To Show Msgs</a></li>
	</ul>
</body>
</html>
