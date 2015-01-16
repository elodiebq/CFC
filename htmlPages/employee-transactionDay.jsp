<jsp:include page="employee-toptemplate.jsp" />
<form method="POST" >
				
		<table>
			<tr>
				<td> New Trading Date </td>
				<td><input type="date" name="endDate" value=""/></td>
			</tr>
			
			<tr>
				<td> Fund Name </td>
				<td>(MUTF:VGSTX)</td>
				<td> Price: </td>
				<td><input type="price" name=“newPrice" value=""/></td>

			</tr>

			<tr>
				<td> Fund Name </td>
				<td>(MUTF:ABCDE)</td>
				<td> Price: </td>
				<td><input type="price" name=“newPrice" value=""/></td>

			</tr>
			
			
		
			<tr>
				<td colspan="4" align="right">
					<input type="submit" name="button" value="Update"/>
				</td>
			</tr>
		</table>
		
		
	</form>
	
	<jsp:include page="employee-bottomtemplate.jsp" />
