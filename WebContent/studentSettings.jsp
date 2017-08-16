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
<jsp:include page="studentHeader.jsp"></jsp:include>
<% 
if(session.getAttribute("studentId")==null){
	response.sendRedirect("studentLogin.jsp");
}
%>
<section id="main-content">
	<section class="wrapper">

<div class="form-w3layouts">
<form action="UploadPhoto" method="post" enctype="multipart/form-data">
<input type="file" name="profile_pic" accept="image/*">
<button type="submit" >Upload</button>
</form><br/><br/>
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Change Password
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
							</span>
						</header>
						<div class="panel-body">
                            <form role="form" class="form-horizontal " action="ChangePassword" method="post" onsubmit="return changePasswordValidate()" name="changePassword">
                                <div class="form-group has-success">
                                    <label class="col-lg-3 control-label">Current Password</label>
                                    <div class="col-lg-6">
                                        <input type="password" placeholder="" id="f-name" class="form-control" name="current_password" required>
                                    </div>
                                </div>
                                <div class="form-group has-success">
                                    <label class="col-lg-3 control-label">New Password</label>
                                    <div class="col-lg-6">
                                        <input type="password" placeholder="" id="f-name" class="form-control" name="new_password" required>
                                        <p class="help-block form-group has-error" id="newPassCheck"></p>
                                    </div>
                                </div>
                                <div class="form-group has-success">
                                    <label class="col-lg-3 control-label">Confirm New Password</label>
                                    <div class="col-lg-6">
                                        <input type="password" placeholder="" id="f-name" class="form-control" name="confirmNew_password" required>
                                        <p class="help-block form-group has-error" id="checkPass"></p>
                                    </div>
                 				</div>
                 				 <div class="form-group">
                                    <div class="col-lg-offset-3 col-lg-6">
                                        <button class="btn btn-primary" type="submit">Change Password</button>
                                    </div>
                                </div>
                 			</form>
                 		</div>
                 	</section>
                 </div>
               </div>
           <form action="DeactivateStudent" method="get">
<button type="submit">Deactivate</button>
<span>Note: Once Account is deactivated can only be activated by Librarian</span>
</form>
            </div>
</section></section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>

</body>
</html>