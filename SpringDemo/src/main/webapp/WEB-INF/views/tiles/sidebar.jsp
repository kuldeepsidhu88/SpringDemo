<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div id="login">
	<sec:authorize access="hasAnyRole('ROLE_SPITTER','ROLE_ADMIN')">
		<h3>
			User loggedin : 
			<sec:authentication property="principal.username" />
		</h3>
		<h2><a href='<s:url value="/j_spring_security_logout"></s:url>'>Logout</a></h2>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<h3>Sign in to Spitter</h3>
		<s:url value="/j_spring_security_check" var="authUrl"></s:url>


		<form action="${authUrl}" method="post">
			<fieldset>
				<table cellspacing="0">
					<tr>
						<th>Username</th>
						<td><input id="username_or_email" name="j_username"
							type="text" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input id="password" name="j_password" type="password" />
							<small><a href="#">Forgot Password?</a> </small></td>
					</tr>
					<tr>
						<th></th>
						<td><input id="remember_me"
							name="_spring_security_remember_me" type="checkbox" />Remember
							Me</td>
					</tr>
					<tr>
						<th></th>
						<td><input name="submit" type="submit" value="Sign In" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
		<h2><a href='<s:url value="/spitters/new"></s:url>'>Register</a></h2>
	</sec:authorize>
</div>