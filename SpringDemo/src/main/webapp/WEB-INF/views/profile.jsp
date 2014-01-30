<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<c:choose>
<c:when test="${spitter != null }">
<table border="solid black 1">
<tr>
<td>Profile Image : </td>
<td><img  src="file:///${spitter.profileImageUrl}" width="200" height="200"></td>
</tr>
<tr>
<td>Username :</td> 
<td>${spitter.username} </td>
</tr>
<tr>
<td>FullName : </td>
<td>${spitter.fullName} </td>
</tr>
<tr>
<td>Email : </td>
<td>${spitter.email} </td>
</tr>
</table>
</c:when>
<c:otherwise>
<h2>Your profile details are not avaiable.</h2>
</c:otherwise>
</c:choose>


</div>