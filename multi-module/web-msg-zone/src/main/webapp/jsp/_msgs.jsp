<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/30
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="../css/styles.css">
	<link rel="stylesheet" href="../css/qzon-msg-board.css">
	<script src="../vendor/js/jquery.min.js"></script>
</head>
<body>
<div class="comment_tit">
<h4>留言 <span>(${requestScope.msgListSize})</span></h4>
</div>
<ul class="comment_list" id="comment_list">
	<c:forEach var="i" begin="0" end="${requestScope.msgListSize - 1}" step="1">
		<li>
			<div class="wrap">
				<div class="wrap_left">
					<a href="#" class="peopel_photo"><img src="../images/people_photo.png" width="50" height="50"></a>
				</div>
				<div class="wrap_center">
					<span class="user_info">${requestScope.msgList[i].name}</span>
					<span class="txt_floor">第${requestScope.msgListSize - i}楼</span>
					<div class="comment_content">${requestScope.msgList[i].content}</div>
					<span class="data_time">${requestScope.msgList[i].time}</span>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>
<div class="other">
	<p><a href="#c_tx">我要留言</a></p>
</div>

</body>
</html>
