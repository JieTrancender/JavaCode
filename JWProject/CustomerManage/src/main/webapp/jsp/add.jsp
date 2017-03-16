<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/16
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnore="false" %>
<html>
<head>
	<title>Add</title>
	<script src="<c:url value="/js/jquery.min.js"/>"></script>
	<script>
		$(function() {
		    $("#birthday").datepick({dateFormat:"yy-mm-dd"});
		})
	</script>
</head>
<body>
	<h3>添加客户</h3>
	<form action="<c:url value="/msg.jsp"/> " method="post">
		<table border="0" align="center" width="40%" style="margin-left:100px;">
			<tr>
				<td width="100px">客户名称</td>
				<td width="40%">
					<input type="text" name="name"/>
				</td>
				<td align="left">
					<label id="nameError" class="error">&nbsp;</label>
				</td>
			</tr>
			<tr>
				<td>客户性别</td>
				<td>
					<input type="radio" name="gender" value="男" id="male"/>
					<label for="male">男</label>
					<input type="radio" name="gender" value="女" id="female">
					<label for="female">女</label>
				</td>
				<td>
					<label id="genderError" class="error">&nbsp;</label>
				</td>
			</tr>
			<tr>
				<td>客户生日</td>
				<td>
					<input type="text" name="birthday" id="birthday" readonly="readonly">
				</td>

			</tr>
		</table>
	</form>
</body>
</html>
