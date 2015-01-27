<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Carnegie Financial Service</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="css/flat-ui.css" rel="stylesheet">
<link href="css/cfs.css" rel="stylesheet">

<link rel="shortcut icon" href="img/2.png">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <![endif]-->
</head>
<body>
	<div class="container">
		<br /> <br />
		<h1>Welcome Customer!</h1>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form class="form-signin" action="login.do" method="POST">

					<h3 class="form-signin-heading">Please login</h3>
					<jsp:include page="error.jsp" />
					<div class="form-group has-feedback">
						<input name="email" type="email"
							class="form-control flat input-hg" placeholder="Email address"
							autofocus> <span class="form-control-feedback fui-mail"></span>
					</div>
					<div class="form-group has-feedback">
					<input name="password" type="password"
						class="form-control flat input-hg" placeholder="Password">
						<span class="form-control-feedback fui-lock"></span>
					<input name="action" type="hidden" value="Login">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember me
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>

			</div>

		</div>
		<br /> <br /> <br />
	</div>


	<jsp:include page="customer_bottomtemplate.jsp" />