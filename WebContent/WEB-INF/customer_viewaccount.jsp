<jsp:include page="customer_toptemplate.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="body" class="container">
	<h3>${msg}</h3>
	<jsp:include page="error.jsp" />
	<div class="row">
		<c:choose>
			<c:when test="${not empty msg}">
				<table class="table table-hover ">
					<thead>
						<tr>
							<td align="center">Email</td>
							<td align="center">First Name</td>
							<td align="center">Last Name</td>
							<td align="center">Address Line1</td>
							<td align="center">Address Line2</td>
							<td align="center">City</td>
							<td align="center">State</td>
							<td align="center">Zip Code</td>
							<td align="center">Cash</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">${customer.email}</td>
							<td align="center">${customer.firstName}</td>
							<td align="center">${customer.lastName}</td>
							<td align="center">${customer.addrLine1}</td>
							<td align="center">${customer.addrLine2}</td>
							<td align="center">${customer.city}</td>
							<td align="center">${customer.state}</td>
							<td align="center">${customer.zip}</td>
							<td align="center">${cash}</td>
						</tr>
					</tbody>

				</table>

				<hr />
				<br/><br/>

				<table class="table table-hover ">
					<thead>
						<tr>
							<td style="font-size: x-large">Share Name</td>
							<td style="font-size: x-large">Share amount</td>
							<td style="font-size: x-large">Last trading price</td>
							<td style="font-size: x-large">Total value</td>
						</tr>
					</thead>
					<c:forEach var="record" items="${records}">
						<tr>
							<td><a href="">${record.fundName}</a></td>
							<td>${record.share}</td>
							<td>${record.lastPrice}</td>
							<td>${record.originalPrice}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>

	</div>
</div>

<jsp:include page="customer_bottomtemplate.jsp" />