<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="customer-toptemplate.jsp" />
<%@ page import="databeans.CustomerBean"%>
<p>Welcome Guest!</p>
<form>
	<table>
		<tr>
			<td>Cash Balance</td>
			<td>
			${cash}</td>
		</tr>
		<tr>
			<td>Request Check Amount:</td>
			<td><input name=requestAmount type=â€œtextâ€></td>
		</tr>

		<tr>
			<td colspan = "2" align="center">
				<button name=â€œrequestCheckSubmitâ€ type=â€œbuttonâ onclick="form.submit"€>Request
					Check Submit</button>
			</td>
		</tr>
	</table>

</form>

<jsp:include page="customer-bottomtemplate.jsp" />



