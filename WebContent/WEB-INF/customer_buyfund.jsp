<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="databeans.FundBean"%>
<jsp:include page="customer_toptemplate.jsp" />

<div id="body" class="container">
	<div class="row">
		<div class="col-md-4" id="fund_list">

			<table class="table table-hover">
				<tr>
					<td>Fund ID</td>
					<td>Fund Name</td>
					<td>Fund ticker</td>
				</tr>
				<c:forEach var="fund" items="${funds}">
					<tr>
						<td>${fund.fundId}</td>
						<td>${fund.fundName}</td>
						<td>${fund.symbol}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div class="col-md-8">
			<div class="form_area panel">
				<form method="post" action="buyfund.do">
					<h2 class="form-signin-heading">Buy Funds Here</h2>
					<p>Cash Balance You Have $ ${cash}</p>


					<div class="input-group col-md-10 col-md-offset-1">
						<div class="form-group has-feedback">
							<input type="email" id="inputFunds"
								class="form-control flat input-hg"
								placeholder="Fund name/Fund ticker" name="symbol" /> <span
								class="form-control-feedback fui-new"></span>
						</div>
					</div>
					<div class="input-group col-md-10 col-md-offset-1">
						<div class="form-group has-feedback">
							<input type="text" id="inputAmount"
								class="form-control flat input-hg"
								placeholder="Amount you want to buy" name="amount" /> <span
								class="form-control-feedback fui-credit-card"></span>
						</div>
					</div>
					<div class="input-group col-md-10 col-md-offset-1 button_box">
						<div class="col-md-6">
							<button type="reset" class="btn btn-hg btn btn-default btn-block">
								Reset Form</button>
						</div>
						<div class="col-md-6">
							<button type="submit"
								class="btn btn-hg btn btn-primary btn-block"
								href="customer_viewaccount.jsp" onclick="form.submit();">
								Place Order</button>
						</div>
					</div>
					<jsp:include page="error.jsp" />
					<h4 style="color: green">${msg}</h4>
				</form>
			</div>
		</div>
	</div>
</div>



<jsp:include page="customer_bottomtemplate.jsp" />