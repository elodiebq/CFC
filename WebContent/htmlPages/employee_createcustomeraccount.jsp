
<jsp:include page="employee-toptemplate.jsp" />

<p style="font-size: medium">Create Customer Account</p>



<p>
<form method="post" action="addurl.do" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Email Address:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="url" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="url" /></td>
		</tr>
		<tr>
			<td>Address Line1:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>Address Line2:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>Zip Code:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>Cash Balance:</td>
			<td><input type="text" name="comment" value="0" /></td>
		</tr>
		<input type="hidden" name="action" value="Register"/>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				name="button" value="Create Customer" /></td>
		</tr>
	</table>
</form>
</p>


 <jsp:include page="employee-bottomtemplate.jsp" />
