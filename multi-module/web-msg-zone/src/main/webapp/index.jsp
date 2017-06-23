<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Index | </title>
	<link rel="stylesheet" href="<c:url value="/vendor/css/bootstrap.min.css"/> ">
	<style>
		.index-container {
			min-height: 800px;
			width: 1200px;
			margin: 60px auto 0 auto;
		}
	</style>
</head>
<body>
<%@ include file="/jsp/_header.jsp" %>

<div class="index-container">
	<h2 style="border-bottom:1px solid gray;">User Info:</h2>
	<ul>
		<c:choose>
			<c:when test="${sessionScope.current != null}">
				<li>userId = <span>${sessionScope.current.userAuth.userId}</span></li>
				<li>name = <span>${sessionScope.current.name}</span></li>
				<li>avatar = <span>${sessionScope.current.avatar}</span></li>
				<li>identifier = <span>${sessionScope.current.identifier}</span></li>
				<li>gender = <span>${sessionScope.current.gender}</span></li>
			</c:when>
			<c:otherwise>
				<li>Welcome, <a href="<c:url value="/jsp/login.jsp"/> ">go to login </a> or <a href="<c:url value="/jsp/register.jsp"/> ">go to register.</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
	<h2 style="border-bottom:1px solid gray;">Friends List:</h2>
	<ul id="friends-list"></ul>
</div>

<%@ include file="/jsp/_footer.jsp" %>

<script src="<c:url value="/vendor/js/jquery.min.js"/> "></script>
<script src="<c:url value="/vendor/js/bootstrap.min.js"/> "></script>
<script src="<c:url value="/js/get-data.js"/> "></script>
</body>
</html>
