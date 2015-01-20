<jsp:include page="customer-toptemplate.jsp" />
<div class="inner cover">
<p style="font-size: medium">Welcome John!</p>
<p>
<form method="post" action="addurl.do" enctype="multipart/form-data">
	<table border="0">
		<tr>
		    <td align="center"></td>
		    <td align="center"></td>
			<td align="center"></td>
			
		</tr>
		<tr>
		    <td align="left">User ID</td>
		    <td align="left">1234567</td>
			<td align="right"></td>
			
		</tr>
		<tr>
		    <td align="left">Password</td>
		    <td align="left">********</td>
			<td align="right"><a href = "customer_changepassword.jsp">Edit</a></td>
			
		</tr>
		<tr>
		    <td align="left">Phone</td>
		    <td align="left">412-4787766</td>
			<td align="right"><a href = "">Edit</a></td>
			
		</tr>
		<tr>
		    <td align="left">Address</td>
		    <td align="left">222 Melwood Ave, Apt 100, Pittsburgh, PA</td>
			<td align="right"><a href = "">Edit</a></td>
			
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
</div>

<jsp:include page="customer-bottomtemplate.jsp" />
