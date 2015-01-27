<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="customer_toptemplate.jsp" />


<h3>${msg}</h3>

<%-- 	<c:when test="${not empty msg}">
 --%>
<hr />

		<table border="1">
			<tr>
				<td style="font-size: x-large">TransactionId</td>
				<td style="font-size: x-large">Type</td>
				<td style="font-size: x-large">FundName</td>
				<td style="font-size: x-large">Share</td>				
				<td style="font-size: x-large">Price</td>
				<td style="font-size: x-large">Amount</td>
				<td style="font-size: x-large">Date</td>
			</tr>
			<c:forEach var="record" items="${records}">
				<tr>
					<td>${record.transactionId}</td>
					<td>${record.type}</td>
					<td><a href="">${record.fundName}</a></td>
					<td>${record.share}</td>
					<td>${record.price}</td>
					<td>${record.amount}</td>
					<td>${record.date}</td>
				</tr>
			</c:forEach>
		</table>
<%-- 	</c:when>
 --%>


   <jsp:include page="customer_bottomtemplate.jsp" />
