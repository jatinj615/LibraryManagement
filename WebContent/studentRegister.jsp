<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script type="text/javascript" src="js/validation"></script>
<script type="text/javascript" src="js/usernameCheck.js"></script>
</head>
<body>
<% if( session.getAttribute("librarianId")==null){
	response.sendRedirect("librarianLogin.jsp");
}
%>
<jsp:include page="librarianHeader.jsp"></jsp:include>
<section id="main-content">
	<section class="wrapper">
		<div class="form-w3layouts">
			<div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Student Registration
                            </header>
                            <div class="panel-body">
                            	<div class="form">
									<form class="cmxform form-horizontal" id="signupForm" action="StudentRegister" method="post" onsubmit="return studentRegistrationValidate()" name="stu_register">
										<div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3" >Firstname</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="stu_firstname" type="text" required>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">Lastname</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="stu_lastname" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-3" >Username</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="username" name="stu_username" type="text" onkeyup="checkUsername()" required><span id="userCheck"></span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-3">Password</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="stu_password" type="password" required><span id="pass"></span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="confirm_password" class="control-label col-lg-3">Confirm Password</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="stu_rePassword" type="Password" required><span id="checkPass"></span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="contact" class="control-label col-lg-3">Contact</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="stu_contact" type="text" required><span id="numonly"></span>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">Email</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" name="stu_email" type="text" required>
                                        </div>
                                    </div>    
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Register Student</button>
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
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
         
</body>
</html>