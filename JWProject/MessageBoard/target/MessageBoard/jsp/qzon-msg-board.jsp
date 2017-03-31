<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="../css/styles.css">
	<link rel="stylesheet" href="../css/qzon-msg-board.css">
</head>
<body>
<div id="header"></div>
<div id="all_wrap">
	<!--锚点连接-->
	<a name="c_tx"></a>
	<div class="post_panel">
		<h3>发表您的留言:</h3>
		<div class="comment_editor">
			<div class="editor_top">
				<span><img src="../images/smile.png" width="15" height="15"></span>
			</div>
			<!--输入信息-->
			<div class="editor_body">
				<textarea></textarea>
			</div>
		</div>
		<div class="editor_expand">
			<img src="../images/editor_expand.png" width="172" height="125">
		</div>
	</div>
	<!--提交按钮-->
	<div class="comment_oper">
		<button type="submit" value="提交">提交</button>
	</div>
	<div class="comment_tit">
		<h4>留言 <span>(139)</span></h4>
	</div>
	<!--留言显示信息-->
	<ul class="comment_list" id="comment_list">
		<li>
			<div class="wrap">
				<div class="wrap_left">
					<a href="#" class="peopel_photo"><img src="../images/people_photo.png" width="50" height="50"></a>
				</div>
				<div class="wrap_center">
					<!--头像-->
					<span class="user_info">玲珑色子安红豆</span>
					<!--留言人数-->
					<span class="txt_floor">第3楼</span>
					<!--留言具体内容-->
					<div class="comment_content"></div>
					<!--留言时间-->
					<span class="data_time"></span>
				</div>
			</div>
		</li>
		<c:forEach items="${requestScope.msgList}" var="msg">
			<li>
				<div class="wrap">
					<div class="wrap_left">
						<a href="#" class="peopel_photo"><img src="../images/people_photo.png" width="50" height="50"></a>
					</div>
					<div class="wrap_center">
						<!--头像-->
						<span class="user_info">${msg.name}</span>
						<!--留言人数-->
						<span class="txt_floor">第3楼</span>
						<!--留言具体内容-->
						<div class="comment_content">${msg.content}</div>
						<!--留言时间-->
						<span class="data_time">2017-03-31 7:25</span>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
	<!--底部返回留言部分-->
	<div class="other">
		<p><a href="#c_tx">我要留言</a></p>
	</div>
</div>
<div id="footer"></div>

<script src="../js/vendor/jquery/jquery.min.js"></script>
<script src="../js/qzon-msg-board.js"></script>
</body>
</html>
