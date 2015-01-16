<jsp:include page="employee-toptemplate.jsp" />
<p> Deposit Check </p>

<table>
	<tr>
		<td> Customer Email:</td>
		<td> <input name = “customerEmail” type=“text”></td>
	</tr>
		<tr>
		<td> Customer Name:</td>
		<td> <input name = “customerName” type=“text”></td>
	</tr>
	<tr>
		<td> Amount:</td>
		<td> <input name = “depositAmount” type=“text”></td>
	</tr>
	<tr>
		<td> <button name = “depositConfirm” type=“button”>Deposit Confirm</button></td>
	</tr>
</table>
<jsp:include page="employee-bottomtemplate.jsp" />
