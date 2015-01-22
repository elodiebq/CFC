<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="customer-toptemplate.jsp" />
<<<<<<< HEAD
	<form method="POST" action="buyfund.do">
	 <c:forEach var="error" items="${errors}">
        <h3 style="color: red">${error}</h3>
    </c:forEach>
		<div class="container">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-4">
			<p>
			<form class="form-signin" action="">
				<h2 class="form-signin-heading">Buy Funds Here</h2>
				<label for="inputEmail" class="sr-only">Fund name/Fund ticker</label> <input
					type="email" id="inputFunds" class="form-control"
					placeholder="Fund name/Fund ticker" required="" autofocus="">
					<label
					for="inputPassword" class="sr-only">Price</label> <p> $12</p>
					 <label
					for="inputPassword" class="sr-only">Amount you want to buy</label> <input
					type="password" id="inputAmount" class="form-control"
					placeholder="Amount you want to buy" required="">
				<button class="btn btn-lg btn btn-warning btn-block"
					href="customer_viewaccount.jsp">
					<a href="customer_confirm.jsp">Place Order</a>
				</button>
			</form>
			</p>
=======

<%@ page import="databeans.FundBean"%>
<c:set var="list" value="${fundList}" />
<table>
	<tr>
		<td>Fund ID</td>
		<td>Fund Name</td>
		<td>Fund ticker</td>
	</tr>
	<c:forEach var="fund" items="${fundList}">
		<tr>
			<td>${fund.fundId}</td>
			<td>${fund.fundName}</td>
			<td>${fund.fund.symbol}</td>
		</tr>
	</c:forEach>
</table>


<form method="POST" action="buyfund.do">
	<a href="customer_Fundlist.jsp" target="_blank">See all Funds</a>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<p>
				<form method="post" class="form-signin" action="buyfund.do">
					<h2 class="form-signin-heading">Buy Funds Here</h2>
					<label for="inputEmail" class="sr-only">Fund name/Fund
						ticker</label> <input type="email" id="inputFunds" class="form-control"
						placeholder="Fund name/Fund ticker" required="" autofocus="" name = "symbol">
					<label for="inputPassword" class="sr-only">Cash Balance You Have</label>
					<p>$12</p>
					<label for="inputPassword" class="sr-only">Amount you want
						to buy</label> <input type="text" id="inputAmount" class="form-control"
						placeholder="Amount you want to buy" required="" name = "amount">
					<button type="submit" class="btn btn-lg btn btn-warning btn-block"
						href="customer_viewaccount.jsp" onclick="form.submit();">
						<a href="customer_confirm.jsp">Place Order</a>
					</button>
				</form>

				</p>
			</div>
			<div class="col-md-6"></div>
>>>>>>> FETCH_HEAD
		</div>
	</div>


</form>

<jsp:include page="customer-bottomtemplate.jsp" />