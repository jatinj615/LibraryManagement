<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
<%
String name=(String)session.getAttribute("studentName");
if(name == null || name.isEmpty())
{
	response.sendRedirect("studentLogin.jsp");
}
%>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">

    <a href="#" class="logo">
       LIBRARY
    </a>
</div>
<!--logo end-->
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <!-- image link  -->
                <span class="username" style="padding-left:8px;"> Welcome <%=name %></span>
            
            </a>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<section id="main-content">
	<section class="wrapper">
	<div class="form-w3layouts">
	<div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                     <header class="panel-heading">
                           Reset Password
                            </header>
                            <div class="panel-body">
                            	<div class="form">
									<form name="resetPassword" action="ResetPassword" method="post" class="form-horizontal" onsubmit="return passwordValidate()">
										<div class="form-group ">
                                        <label for="newPassword" class="control-label col-lg-3" >New Password</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="newPassword" type="password" required>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="confNewPass" class="control-label col-lg-3" >Confirm New Password</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="confPassword" type="password" required>
                                           <span id="passwordCheck" style="color:red;"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Change Password</button>
                                        </div>
                                    </div>
								</form>
							</div>
						</div>
					</section>
				</div>
			</div>
		</div>
		</section>
	</section>
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>