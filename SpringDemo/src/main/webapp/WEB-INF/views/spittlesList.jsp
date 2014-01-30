<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Spittles for user : ${username}</h3>
<c:if test="${empty spittleList}">
<h5>No spittles for this user.</h5>
</c:if>
<c:if test="${! empty spittleList }">
<table>
<c:forEach items="${spittleList}" var="spittle"  >
<tr>
<c:out value="${spittle.text}"></c:out><br/>
<i><c:out value="${spittle.createdAt}"></c:out></i>
</tr>
</c:forEach>
</table>
</c:if>

