<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/4/24
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="footer">
	<div class="container">
		<p class="text-muted">
			<%--共有 <a href="<c:url value="/jsp/ip-table.jsp"></c:url> "><c:out value="${fn:length(applicationScope.ipContextMap)}"></c:out> </a> 位用户访问了--%>
			<%--<c:out value="${applicationScope.sessionSum}"></c:out>--%>
			<%--次本网站.--%>
			<%--当前在线人数为 <c:out value="${SessionCounterListener.getActiveSessions()}"></c:out>.--%>
			<%--当前在线人数为：<%= SessionCounterListener.getActiveSessions() %>。--%>
			footer
		</p>
	</div>
</div>
