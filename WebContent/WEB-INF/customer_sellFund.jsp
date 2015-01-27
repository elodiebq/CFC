<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="customer_toptemplate.jsp" />
<%@ page import="databeans.FundBean"%>
<div id="body" class="container">
	<div class="row">
		<div class="col-md-4" id="fund_list">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<td>Share Name</td>
						<td>Symbol</td>
						<td>Share amount</td>
						<td>Last trading price</td>
						<td>Total value</td>
					</tr>
					<c:forEach var="record" items="${records}">
						<tr>
							<td>${record.fundName}</td>
							<td>${record.symbol}</td>
							<td>${record.share}</td>
							<td>${record.lastPrice}</td>
							<td>${record.share*record.lastPrice}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="col-md-8">
			<div class="form_area panel">
				<form method="POST" action="sellfund.do">

					<h2 class="form-signin-heading">Sell Funds Here</h2>
					<h4 style="color: green">${msg}</h4>
					<div class="input-group col-md-8 col-md-offset-2">
						<div class="form-group has-feedback">
							<input name="symbol" type="text"
								class="form-control flat input-hg"
								placeholder="Input Ticker to sell"> <span
								class="form-control-feedback fui-new"></span>
						</div>
					</div>
					<div class="input-group col-md-8 col-md-offset-2">
						<div class="form-group has-feedback">
							<input name="share" type="text"
								class="form-control flat input-hg"
								placeholder="Input selling shares"> <span
								class="form-control-feedback fui-check"></span>
						</div>
					</div>
					<div class="input-group col-md-8 col-md-offset-2 button_box">
						<div class="col-md-6">
							<button type="reset" class="btn btn-hg btn btn-default btn-block">
								Reset Form</button>
						</div>
						<div class="col-md-6">
							<button class="btn btn-hg btn-primary btn-block" type="submit"
								name="button">Sell Confirm</button>
						</div>
					</div>
					<jsp:include page="error.jsp" />

				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="customer_bottomtemplate.jsp" />
