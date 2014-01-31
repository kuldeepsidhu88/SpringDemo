<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Spittles for user : ${username}</h3>
<c:if test="${empty spittleList}">
<h5>No spittles for this user.</h5>
</c:if>
<c:if test="${! empty spittleList }">
<table border="1px" width="100%" >
<c:forEach items="${spittleList}" var="spittle"  >
<tr><td>
<c:out value="${spittle.text}"></c:out><br/>
<i>posted at - <c:out value="${spittle.createdAt}"></c:out></i></td>
</tr>
</c:forEach>
</table>
</c:if>

