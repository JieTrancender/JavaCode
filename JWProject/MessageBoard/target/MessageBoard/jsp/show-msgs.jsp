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
	<link rel="stylesheet" href="../css/msg-styles.css">
	<script src="../js/vendor/jquery/jquery.min.js"></script>
</head>
<body>
	<div id="header">
		<h1><img src="../images/logo.jpg" alt="./images/logo.jpg"/></h1>
		<div class="topNav">
			<p><a href="#">登录</a><span>|</span></p>
			<p><a href="#">注册</a><span>|</span></p>
			<p><a href="#">个性化服务</a>|<span></span></p>
			<p><a href="#">心声社区</a></p>
		</div>
	</div>
	<div id="msg-main">
		<%--<div class="msg-board">
			<div class="msg-avator">
				<img src="../images/avator.jpg" alt="./images/avator.jpg">
			</div>
			<div class="msg-right">
				<div class="msg-title">
					<h3>心花怒放却开到荼蘼<span>Jason</span></h3>
					<span class="right">2013-12-07 01:09</span>
				</div>
				<div class="msg-content">
					<p>有时候，盲目地穿梭在熙熙攘攘的人群中，没有方向，也没有预定的目的，走着走着忽然就感到寂寞了，走着走着忽然就犹豫了，走着走着忽然就好想逃离。想要逃离喧嚣的尘世，寻找一个安静的角落，静静地释放自己，释放自己所有的纠结还有压抑。</p>
				</div>
			</div>
		</div>
		<div class="msg-board">
			<div class="msg-avator">
				<img src="../images/avator.jpg" alt="./images/avator.jpg">
			</div>
			<div class="msg-right">
				<div class="msg-title">
					<h3>心花怒放却开到荼蘼<span>Jason</span></h3>
					<span class="right">2013-12-07 01:09</span>
				</div>
				<div class="msg-content">
					<p>有时候，盲目地穿梭在熙熙攘攘的人群中，没有方向，也没有预定的目的，走着走着忽然就感到寂寞了，走着走着忽然就犹豫了，走着走着忽然就好想逃离。想要逃离喧嚣的尘世，寻找一个安静的角落，静静地释放自己，释放自己所有的纠结还有压抑。</p>
				</div>
			</div>
		</div>
		<div class="msg-board">
			<div class="msg-avator">
				<img src="../images/avator.jpg" alt="./images/avator.jpg">
			</div>
			<div class="msg-right">
				<div class="msg-title">
					<h3>心花怒放却开到荼蘼<span>Jason</span></h3>
					<span class="right">2013-12-07 01:09</span>
				</div>
				<div class="msg-content">
					<p>有时候，盲目地穿梭在熙熙攘攘的人群中，没有方向，也没有预定的目的，走着走着忽然就感到寂寞了，走着走着忽然就犹豫了，走着走着忽然就好想逃离。想要逃离喧嚣的尘世，寻找一个安静的角落，静静地释放自己，释放自己所有的纠结还有压抑。</p>
				</div>
			</div>
		</div>--%>

		<c:forEach items="${requestScope.msgList}" var="msg">
			<%--${msg}<br/>--%>
			<div class="msg-board">
				<div class="msg-avator">
					<img src="../images/avator.jpg" alt="./images/avator.jpg">
				</div>
				<div class="msg-right">
					<div class="msg-title">
						<h3>${msg.title}<span>${msg.name}</span></h3>
						<span class="right">2013-12-07 01:09</span>
					</div>
					<div class="msg-content">
						<p>${msg.content}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="footer">
		<p>@2017 Jason.Allrights reserved.</p>
	</div>
</body>
</html>
