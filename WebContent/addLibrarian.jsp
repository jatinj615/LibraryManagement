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
<script type="text/javascript" src="js/validation"></script></head>
<body>
<%
if( session.getAttribute("adminName")==null){
	response.sendRedirect("adminLogin.jsp");
}
%>
<jsp:include page="adminHeader.jsp"></jsp:include>
<section id="main-content">
		<section class="wrapper">
			<div class="form-w3layouts">
				<div class="row">
        			<div class="col-lg-12">
        				<section class="panel">
           				 	<header class="panel-heading">
               				 Add Librarian
            				</header>
            				<div class="panel-body">
           					 	<div class="position-center">
           					 		<form action="AddLibrarian" method="post" class="form-horizontal bucket-form" name="add" onsubmit="addLibrarianFormValidate();">
 										<div class="form-group">
                        					<label class="col-sm-3 control-label">Librarian Name</label>
                       						<div class="col-sm-6">
                            					<input type="text" class="form-control" name="name">
                        					</div>
                   	 					</div>
                   	 					<div class="form-group">
                        					<label class="col-sm-3 control-label">Password</label>
                       						<div class="col-sm-6">
                            					<input type="password" class="form-control" name="password">
                            					<span id="pass"></span><br/>
                        					</div>
                   	 					</div>
                   	 					<div class="form-group">
                        					<label class="col-sm-3 control-label">Enter Email</label>
                       						<div class="col-sm-6">
                            					<input type="text" class="form-control" name="email">
                        					</div>
                   	 					</div>
                   	 					<div class="form-group">
                        					<label class="col-sm-3 control-label">Address</label>
                       						<div class="col-sm-6">
                            					<input type="text" class="form-control" name="address">
                        					</div>
                   	 					</div>
                   	 					<div class="form-group">
                        					<label class="col-sm-3 control-label">City</label>
                       						<div class="col-sm-6">
                            					<input type="text" class="form-control" name="city">
                        					</div>
                   	 					</div>
                   	 					<div class="form-group">
                        					<label class="col-sm-3 control-label">Contact</label>
                       						<div class="col-sm-6">
                            					<input type="text" class="form-control" name="contact">
                            					<span id="numonly"></span><br/>
                        					</div>
                   	 					</div>
                   	 					<div class="form-group">
        									<div class="col-lg-offset-2 col-lg-10" style="padding-left:70px;">
          										<button type="submit" class="btn btn-info">Add Librarian</button>
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