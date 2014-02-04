<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div class="basic">
<h1>${message}</h1>
<sec:authorize access="hasAnyRole('ROLE_SPITTER','ROLE_ADMIN')">
	<h1>
		Welcome
		<sec:authentication property="principal.username" />
	</h1>
	<h1>Post a new Spittle</h1>
	<c:url value="/spittles" var="url"/>
	<form method="post" action="${url}">
		<textarea name="spittleText" id="spittle" rows="4" cols="40" placeholder="Write your spittle" ></textarea><br/>
		<input type="submit" value="Submit"/>
	</form>
</sec:authorize>


<c:if test="${login_error ne ''}">
	<h2>${login_error}</h2>
</c:if>
</div>
