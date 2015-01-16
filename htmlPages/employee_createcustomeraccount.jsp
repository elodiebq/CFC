
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
			<td>Name:</td>
			<td><input type="text" name="url" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td>Cash Balance:</td>
			<td><input type="text" name="comment" value="0"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				name="button" value="Create Customer" /></td>
		</tr>
	</table>
</form>
</p>

 <jsp:include page="employee-bottomtemplate.jsp" />
