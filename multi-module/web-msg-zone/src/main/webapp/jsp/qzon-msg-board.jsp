<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/30
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="<c:url value="/css/qzon-msg-board.css"/> ">
	<link rel="stylesheet" href="<c:url value="/css/styles.css"/> ">
	<script src="<c:url value="/vendor/js/jquery.min.js"/> "></script>
	<script src="<c:url value="/js/qzon-msg-board.js"/> "></script>
</head>
<body>
<div id="header"></div>
<div id="all_wrap">
	<!--锚点连接-->
	<a name="c_tx"></a>
	<div class="post_panel">
		<h3>发表您的留言:</h3>
		<form id="msg-board">
			<div class="comment_editor">
				<div class="editor_top">
					<span><img src="../images/smile.png" width="15" height="15"></span>
				</div>
				<div class="editor_body">
					<textarea id="msg-text"></textarea>
				</div>
			</div>
			<div class="editor_expand">
				<img src="../images/editor_expand.png" width="172" height="125">
			</div>
	<%--</div>--%>
			<div class="comment_oper">
				<button type="submit" value="提交" onsubmit="return doValidate(this)">提交</button>
			</div>
		</form>
	</div>
	<div id="comment_div">
		<div class="comment_tit">
			<h4>留言 <span id = "msgSize">(${requestScope.msgArrayListSize})</span></h4>
		</div>
		<ul class="comment_list" id="comment_list">
		</ul>
		<%--<div class="other">--%>
			<%--<p><a href="#c_tx">我要留言</a></p>--%>
		<%--</div>--%>
	</div>
</div>

<%--<div id="footer"></div>--%>

</body>
</html>
