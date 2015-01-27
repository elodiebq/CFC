<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="databeans.FundBean"%>
<jsp:include page="customer_toptemplate.jsp" />
<title>Customer - Search Fund Result</title>

<div id="body" class="container">
	<div class="row">
		<div class="col-md-4" id="fund_list">
			<jsp:include page="error.jsp" />
			<table class="table table-hover ">
				<tr>
					<td>Fund ID</td>
					<td>Fund Name</td>
					<td>Fund ticker</td>
					<td>Research Fund</td>
				</tr>
				<c:forEach var="fund" items="${funds}">
					<tr>
						<td>${fund.fundId}</td>
						<td>${fund.fundName}</td>
						<td>${fund.symbol}</td>
						<td><form method="POST" action="research_funds.do">
								<input type="hidden" name="fundId" value=${fund.fundId}><input
									type="submit" value="Research" class="btn btn-primary" />
							</form></td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div class="col-md-8">
			<p id="data" style="display: none;"><c:forEach var="price" items="${prices}">${price.price},</c:forEach></p>
			<p id="label" style="display: none;"><c:forEach var="price" items="${prices}">${price.date},</c:forEach></p>
			<canvas id="myChart" width="700" height="420"></canvas>
		</div>
	</div>
</div>
<jsp:include page="customer_bottomtemplate.jsp" />