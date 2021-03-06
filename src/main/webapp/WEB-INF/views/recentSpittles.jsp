<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div class="basic">
<h3>Recent Spittles : </h3>
<c:if test="${empty spittleList }">
<h3>No spittles posted</h3>
</c:if>
<c:if test="${!empty spittleList}">
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal.username" var="loginuser"/>
</sec:authorize>
<table border="1" width="100%">
<c:forEach items="${spittleList}" var="spittle">
<tr>
<c:set value="${spittle.username}" var="username"/>
<c:url value="/spitters/${username}" var="url"/>
<td width="10%"><a href="${url}">${username}</a> </td>
<td><c:out value="${spittle.text}"/><br/><i>posted at - <c:out value="${spittle.createdAt}"/></i></td>
<c:if test="${spittle.username eq loginuser}"><td width="10%"><a href="<c:url value="/spitters/delete/${spittle.id}"/>">Delete</a></td></c:if>
</tr>
</c:forEach>
</table>
</c:if>
</div>