<jsp:include page="customer-toptemplate.jsp" />
	<form method="POST" action="change-pwd.do">
				
		<table>
			<tr>
				<td> Fund Name </td>
				<td>Vanguard Star Fund Investor Shares</td>
			</tr>
			
			<tr>
				<td> Fund Name </td>
				<td>(MUTF:VGSTX)</td>
			</tr>
			
			<tr>
				<td> Price</td>
				<td>24.46</td>
			</tr>
		
	
				<td> Shares you want to buy: </td>
				<td><input type="password" name="confirmPassword" value=""/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="button" value="Place Order"/>
				</td>
			</tr>
		</table>
		
		
	</form>

<jsp:include page="customer-bottomtemplate.jsp" />