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
  	<div id="header" >
  		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  			<div class="navbar-header">
  				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
  					<span class="sr-only">Toggle navigation</span>
  				</button>
  				<a class="navbar-brand" href="index.html">CFS</a>
  			</div>
  			<div class="collapse navbar-collapse" id="navbar-collapse-01">
  				<ul class="nav navbar-nav">
  					<li><a href="research_funds.do">Research Funds</a></li>
  					<li><a href="buyfund.do">Buy Funds</a></li>
  					<li><a href="sellfund.do">Sell Funds</a></li>
  					<li class="dropdown">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">My Account <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="viewAccount.do">View Account</a></li>
							<li><a href="requestcheck.do">Request Check</a></li>
							<li><a href="customer_change_pwd.do">Change Password</a></li>
							<li><a href="viewTransactionHistory.do">View Transaction History</a></li>
							<li><a href="logout.do">Log out</a></li>
						</ul>
					</li>
					<li><a href="">Contact Us</a></li>
  				</ul>
  				<form class="navbar-form navbar-right" action="research_funds.do" method="POST">
  					<div class="form-group">
  						<div class="input-group">
  							<input class="form-control" name="fundKeyWord" type="search" placeholder="Search Funds">
  							<span class="input-group-btn">
  								<button type="submit" class="btn"><span class="fui-search"></span></button>
  							</span>
  						</div>
  					</div>
  				</form>
  			</div><!-- /.navbar-collapse -->
  		</nav><!-- /navbar -->
  	</div>