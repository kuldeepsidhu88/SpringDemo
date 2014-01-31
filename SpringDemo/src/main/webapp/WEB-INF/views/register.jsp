<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="basic">
	<h1>Create a free Spitter account</h1>
	
	<sf:form method="POST" modelAttribute="spitter" enctype="multipart/form-data">
	<sf:errors path="*" cssClass="error"></sf:errors>
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label>Full Name : </label></th>
					<td><sf:input path="fullName" size="15" id="user_full_name" /><br/>
					<sf:errors path="fullName" cssClass="error"></sf:errors>
					</td>
				</tr>
				<tr>
					<th><label>Username : </label></th>
					<td><sf:input path="username" size="15" maxlength="15"
							id="user_screen_name" /><small>No spaces</small><br/>
							<sf:errors path="username" cssClass="error" delimiter=","></sf:errors></td>
				</tr>
				<tr>
					<th><label>Password : </label></th>
					<td><sf:password path="password" size="15" id="user_password" /><small>3
							chars</small><br/>
							<sf:errors path="password" cssClass="error"></sf:errors></td>
				</tr>
				<tr>
					<th><label>Email Address :</label></th>
					<td><sf:input path="email" size="30" id="user_email" /><small>In
							case you forgot password</small>
							<br/>
							<sf:errors path="email" cssClass="error"></sf:errors></td>
				</tr>
				<tr>
					<th></th>
					<td><sf:checkbox path="updateByEmail"
							id="user_send_email_newsletter" /><label>Send me email
							updates!</label></td>
				</tr>
				<tr>
					<th>Profile image : </th>
					<td><input name="image" type="file"/></td>
				</tr>
				<tr>
					<th></th>
					<td><input name="commit" type="submit"
						value="I accept. Create my account"/></td>
				</tr>
			</table>
		</fieldset>
	</sf:form>
</div>