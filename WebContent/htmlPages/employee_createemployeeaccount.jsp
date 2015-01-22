<jsp:include page="employee-toptemplate.jsp" />

<p style="font-size: medium">Create Employee Account</p>



<p>
<form method="post" action="addurl.do" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Employee Username:</td>
			<td><input type="text" name="userName" /></td>
		</tr>
		<tr>
            <td>Employee FirstName:</td>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <td>Employee LastName:</td>
            <td><input type="text" name="lastName" /></td>
        </tr>
		<tr>
			<td>Password:</td>
			<td><input type="text" name="password" /></td>
		</tr>
		<input type="hidden" name="action" value="Register"/>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				name="button" value="Create Employee" /></td>
		</tr>
	</table>
</form>
</p>
 <jsp:include page="employee-bottomtemplate.jsp" />
