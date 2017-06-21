<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1><img src="<c:url value="/images/logo.jpg"/>" alt="<c:url value="/images/logo.jpg"/>"/></h1>
<div class="topNav">
	<p>
		<c:choose>
			<c:when test="${sessionScope.current.name != null}">
				<a href="#">${sessionScope.current.name}</a><span></span>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/jsp/login.jsp"/>">登录</a><span></span>
			</c:otherwise>
		</c:choose>
	</p>
	<p>
		<c:choose>
			<c:when test="${sessionScope.current.name != null}">
				<a href="<c:url value="/LoginServlet"/> ">注销</a><span></span>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/jsp/register.jsp"/>">注册</a><span></span>
			</c:otherwise>
		</c:choose>
	</p>
	<p><a href="#">个性化服务</a><span></span></p>
	<p><a href="#">心声社区</a></p>
</div>
