<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Access Denied</title>
<link rel="stylesheet" href=<c:url value="/resources/css/main.css"></c:url>/>
</head>
<body>
<h2>Sorry ! You are not authorized to view this page</h2>
<h2><a href='<s:url value="/welcome"></s:url>'>Back to Home</a></h2>
<h2><a href='<s:url value="/j_spring_security_logout"></s:url>'>Logout</a></h2>
</body>
</html>