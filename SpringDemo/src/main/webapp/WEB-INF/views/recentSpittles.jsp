<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="basic">
<h3>Recent Spittles : </h3>
<c:if test="${empty spittleList }">
<h3>No spittles posted</h3>
</c:if>
<c:if test="${!empty spittleList}">

<table border="1" width="100%">
<c:forEach items="${spittleList}" var="spittle">
<tr>
<c:set value="${spittle.username}" var="username"/>
<c:url value="/spitters/${username}" var="url"/>
<td width="10%"><a href="${url}">${username}</a> </td>
<td><c:out value="${spittle.text}"/><br/><i>posted at - <c:out value="${spittle.createdAt}"/></i></td>
</tr>
</c:forEach>
</table>
</c:if>
</div>