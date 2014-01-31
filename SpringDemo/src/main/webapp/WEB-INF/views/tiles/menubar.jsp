<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<div id="menu">
<ul>
<sec:authorize access="permitAll">
<li><h3><a href='<s:url value="/welcome"></s:url>'>Home</a></h3></li>
<li><h3><a href='<s:url value="/spittles/recent"></s:url>'>Recent Spittles</a></h3></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_SPITTER','ROLE_ADMIN')">
<sec:authentication property="principal.username" var="username"/>
<li><h3><a href='<s:url value="/spitters/spittles?spitter=${username}"></s:url>'>My Spittles</a></h3></li>
<li><h3><a href='<s:url value="/spitters/${username}"></s:url>'>My Profile</a></h3></li>
<li><h3><a href='<s:url value="/j_spring_security_logout"></s:url>'>Logout</a></h3></li>
</sec:authorize>
</ul>
</div>