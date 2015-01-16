

<jsp:include page="employee-toptemplate.jsp" />

<p style="font-size: medium">Select a customer</p>

<select name="customerlist" size="1" class="arrow" tabindex="11">
	<c:forEach var="customer" items="${customerList}">
		<option value="customerid"><span class="menu-item"> <a
				href="list.do?userid=${customer.customerid}">${customer.firstName}
					${customer.lastName}</a>
			</span>
		</option>
	</c:forEach>
</select><br>
<p> Or type a customer email here:
<input type="text"><button>Submit</button></input>


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
	<tr>
		<td style="font-size: x-large">Share Name</td>
		<td style="font-size: x-large">Share amount</td>
		<td style="font-size: x-large">Last trading price</td>
		<td style="font-size: x-large">Total value</td>
	</tr>
	<tr>
		<td ><a href="">Apple</a></td>
		<td >100</td>
		<td >$23.56</td>
		<td >$2356</td>
	</tr>
	

</table>
</p>
<jsp:include page="employee-bottomtemplate.jsp" />
