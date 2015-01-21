<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="img/icon.png">

<title>CFS Customer Login</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/cover.css" rel="stylesheet">


<script src="js/ie-emulation-modes-warning.js"></script>


</head>

<body>

    <div class="site-wrapper">

        <div class="site-wrapper-inner">



            <div class="container">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <form class="form-signin" action="login.do" method="GET">
                            <h2 class="form-signin-heading">Please login</h2>
                            <input name="email" type="email" class="form-control" placeholder="Email address" required="" autofocus="">
                            <input name= "password" type="password" class="form-control" placeholder="Password" required="">
                            <input name= "action" type="hidden" value="Login">
                            <p id="error_info">${errors}</p>
                            <div class="checkbox">
                                <label> <input type="checkbox" value="remember-me">
                                    Remember me
                                </label>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                        </form>


                        <div class="inner">
                            <p>
                                Copy right deserved to <a href="https://www.cmu.edu"
                                    target="_blank">CMU</a>, by <a
                                    href="https://www.facebook.com/biqiu.li" target="_blank">@Rachel</a>.
                            </p>
                        </div>

                    </div>
                    <div class="col-md-4"></div>

                </div>

            </div>

        </div>

    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script
        src="./Cover Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>

</body>
</html>


