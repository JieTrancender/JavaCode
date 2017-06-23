<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<p>
	共有 <a href="<c:url value="/jsp/ip-table.jsp"></c:url> "><c:out value="${fn:length(applicationScope.ipContextMap)}"></c:out> </a> 位用户访问了
	<c:out value="${applicationScope.sessionSum}"></c:out>
	次本网站.
	当前在线人数为 <c:out value="${SessionCounterListener.getActiveSessions()}"></c:out>.
</p>