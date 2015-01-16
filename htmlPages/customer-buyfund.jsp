<jsp:include page="customer-toptemplate.jsp" />
	<form method="POST" action="change-pwd.do">
			<a href="customer_Fundlist.jsp" target="_blank">See all Funds</a>	
		<table>
			<tr>
				<td> Fund Name </td>
				<td><input type="text" name="fundName" value=""/></td>
			</tr>
			
			<tr>
				<td> Fund Ticker </td>
				<td><input type="text" name="ticker" value=""/></td>
			</tr>
			
			<tr>
				<td> Price</td>
				<td>$24.46</td>
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