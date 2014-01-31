<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div class="basic">
<sec:authorize access="hasAnyRole('ROLE_SPITTER','ROLE_ADMIN')">
	<h1>
		Welcome
		<sec:authentication property="principal.username" />
	</h1>
</sec:authorize>
<h1>${message}</h1>

<c:if test="${login_error ne ''}">
	<h2>${login_error}</h2>
</c:if>
</div>
