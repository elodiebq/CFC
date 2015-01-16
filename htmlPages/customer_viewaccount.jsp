

<jsp:include page="customer-toptemplate.jsp" />

<p style="font-size: medium">Welcome David!</p>

<p>
<form method="post" action="addurl.do" enctype="multipart/form-data">
	<table>
		<tr>
			<td align="center">Name</td>
			<td align="center">Address</td>
			<td align="center">Last trading date</td>
			<td align="center">cash balance</td>
		</tr>
		<tr>
			<td align="center">David</td>
			<td align="center">5939 Fifth Ave, Pittsburgh, PA</td>
			<td align="center">Jan, 15, 2015</td>
			<td align="center">$ 347.59</td>
		</tr>
	</table>
</form>
</p>
<hr />

<p>
	
<table>
	<tr>
		<td style="font-size: x-large">Share Name</td>
		<td style="font-size: x-large">Share amount</td>
		<td style="font-size: x-large">Last trading price</td>
		<td style="font-size: x-large">Total value</td>
	</tr>
	

</table>
</p>

<jsp:include page="customer-bottomtemplate.jsp" />
