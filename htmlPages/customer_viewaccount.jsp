<jsp:include page="customer-toptemplate.jsp" />

<p style="font-size: medium">Welcome John!</p>


<p>
<form method="post" action="addurl.do" enctype="multipart/form-data">
	<table border="1">
		<tr>
		    <td align="center">Email</td>
		    <td align="center">First Name</td>
			<td align="center">Last Name</td>
			<td align="center">Address Line1</td>
			<td align="center">Address Line2</td>
			<td align="center">City</td>
			<td align="center">State</td>
			<td align="center">Zip Code</td>
			<td align="center">Last trading date</td>
			<td align="center">cash balance</td>
		</tr>
		<tr>
		    <td align="center">david@gmail.com</td>
		    <td align="center">David</td>
			<td align="center">Dai</td>
			<td align="center">5939 Fifth Ave</td>
			<td align="center">Apt 20</td>
			<td align="center">Pittsburgh</td>
			<td align="center">PA</td>
			<td align="center">15232</td>
			<td align="center">Jan, 15, 2015</td>
			<td align="center">$ 347.59</td>
		</tr>
	</table>
</form>
</p>
<hr />

<p>
	
<table border="1">
<h2> Current Fund Shares</h2>
	<tr>
		<td style="font-size: large">Share Name</td>
		<td style="font-size: large">Share amount</td>
		<td style="font-size: large">Last trading price</td>
		<td style="font-size: large">Total value</td>
	</tr>
	<tr>
	
		<td style="font-size: medium"><a href="">Apple</a></td>
		<td style="font-size: medium">1000</td>
		<td style="font-size: medium">$23.00</td>
		<td style="font-size: medium">$23000</td>
	</tr>
	

</table>
</p>

<jsp:include page="customer-bottomtemplate.jsp" />
