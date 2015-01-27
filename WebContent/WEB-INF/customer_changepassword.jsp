<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="customer_toptemplate.jsp" />
<br />
<br />
<div id="body" class="container">
	<div class="row">


		<div class="col-md-8 col-md-offset-2">
			<div class="form_area panel">

				<form class="form-signin" method="POST"
					action="customer_change_pwd.do">
					<h2 class="form-signin-heading">Change Password Here</h2>
					<jsp:include page="error.jsp" />
					<h4 style="color: green">${message}</h4>
					<div class="input-group col-md-10 col-md-offset-1">
                        <div class="form-group has-feedback">
                            <input type="password" id="inputEmail"
                                class="form-control flat input-hg" placeholder="Old Password"
                                name="oldPassword"> <span
                                class="form-control-feedback fui-lock"></span>
                        </div>
                    </div>
					<div class="input-group col-md-10 col-md-offset-1">
						<div class="form-group has-feedback">
							<input type="password" id="inputEmail"
								class="form-control flat input-hg" placeholder="New Password"
								name="newPassword"> <span
								class="form-control-feedback fui-lock"></span>
						</div>
					</div>
					<div class="input-group col-md-10 col-md-offset-1">
					
						<div class="form-group has-feedback">
							<input type="password" id="inputPassword"
								class="form-control flat input-hg"
								placeholder="Confirm New Password" name="confirmPassword">
							<span class="form-control-feedback fui-check"></span>
						</div>
					</div>
					<div class="input-group col-md-10 col-md-offset-1 button_box">
						<div class="col-md-6">
							<button type="reset" class="btn btn-hg btn btn-default btn-block">
								Reset Form</button>
						</div>
						<div class="col-md-6">
							<button class="btn btn-hg btn btn-primary btn-block"
								onclick="form.submit();">Confirm</button>
						</div>
					</div>

				</form>

			</div>
		</div>

	</div>
</div>
<br />
<br />
<br />
<jsp:include page="customer_bottomtemplate.jsp" />
