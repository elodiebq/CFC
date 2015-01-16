

<jsp:include page="employee-toptemplate.jsp" />

<p style="font-size: medium">select a customer</p>

<select name="customerlist" size="1" class="arrow" tabindex="11">
	<c:forEach var="customer" items="${customerList}">
		<option value="customerid"><span class="menu-item"> <a
				href="list.do?userid=${customer.customerid}">${customer.firstName}
					${customer.lastName}</a>
			</span>
		</option>
	</c:forEach>
</select>


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
	<c:set var="list" value="${shareList}" />
<table>
	<tr>
		<td style="font-size: x-large">Share Name</td>
		<td style="font-size: x-large">Share amount</td>
		<td style="font-size: x-large">Last trading price</td>
		<td style="font-size: x-large">Total value</td>
	</tr>
	<c:forEach var="share" items="${shareList}">
		<tr>
			<td style="font-size: x-large">${share}</td>
			<td style="font-size: x-large">${amount}</td>
			<td style="font-size: x-large">${lastprice}</td>
			<td style="font-size: x-large">${value}</td>
		</tr>
	</c:forEach>

</table>
</p>

<jsp:include page="employee-bottomtemplate.jsp" />
