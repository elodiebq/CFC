<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="databeans.CustomerBean"%>
<jsp:include page="customer_toptemplate.jsp" />
<br />
<br />
<div id="body" class="container">
	<div class="row">
		
		<div class="form_area panel">
			<form method="post" action="requestcheck.do">
				<h2 class="form-signin-heading">Request Check</h2>
				<p>Cash Balance You Have $ ${cash}</p>

				<div class="input-group col-md-10 col-md-offset-1">
					<div class="form-group has-feedback">
						<input type="text" id="inputAmount"
							class="form-control flat input-hg"
							placeholder="Request Check Amount" name="amount" /> <span
							class="form-control-feedback fui-credit-card"></span>
					</div>
				</div>
				<div class="input-group col-md-10 col-md-offset-1 button_box">
					<div class="col-md-6">
						<button type="reset" class="btn btn-hg btn btn-default btn-block">
							Reset Form</button>
					</div>
					<div class="col-md-6">
						<button type="button" class="btn btn-hg btn btn-primary btn-block"
							name="requestCheckSubmit" onclick="form.submit();">
							Request Check Submit</button>
					</div>
				</div>
				<jsp:include page="error.jsp" />
				<h4 style="color: green">${message}</h4>
			</form>
		</div>

	</div>
</div>
<br />
<br />

<jsp:include page="customer_bottomtemplate.jsp" />



