<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href=<c:url value="/resources/css/main.css"></c:url>/>
<title>Home</title>
</head>
<body>
<table border="1" width="100%" height="100%">
<tr height="100px"><td colspan="2"><tiles:insertAttribute name="top"></tiles:insertAttribute></td></tr>
<tr height="50px"><td colspan="2"><tiles:insertAttribute name="menu"></tiles:insertAttribute></td></tr>
<tr height="50%">
<td colspan="1" width="70%"><tiles:insertAttribute name="content"></tiles:insertAttribute></td> 
<td colspan="1"><tiles:insertAttribute name="side"></tiles:insertAttribute></td> 
</tr>


</table>
</body>
</html>