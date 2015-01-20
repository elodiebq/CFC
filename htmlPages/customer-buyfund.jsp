<jsp:include page="customer-toptemplate.jsp" />
	<form method="POST" action="change-pwd.do">
			<a href="customer_Fundlist.jsp" target="_blank">See all Funds</a>	
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
		</div>
		<div class="col-md-6"></div>
	</div>
</div>
		
		
	</form>

<jsp:include page="customer-bottomtemplate.jsp" />