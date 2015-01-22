<jsp:include page="customer-toptemplate.jsp" />

<div class="container">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-4">
			<p>
			<form class="form-signin" action="customer_change_pwd.do">
				<h2 class="form-signin-heading">Change Password Here</h2>
				<label for="inputEmail" class="sr-only">Old Password</label> <input
					type="email" name="oldPassword" class="form-control"
					placeholder="old password" required="" autofocus="" > 
				<label for="inputEmail" class="sr-only">New Password</label> <input
					type="email" name="newPassword"class="form-control"
					placeholder="new password" required="" autofocus=""> 

					<label
					for="inputPassword" class="sr-only">Confirm New Password</label> <input
					type="password" name="confirmPassword" class="form-control"
					placeholder="Confirm New Password" required="">
				<button class="btn btn-lg btn btn-warning btn-block"
					href="customer_viewaccount.jsp">
					<a href="customer_confirm.jsp">Confirm</a>
				</button>
			</form>
			</p>
		</div>
		<div class="col-md-6"></div>
	</div>
</div>

<jsp:include page="customer-bottomtemplate.jsp" />
