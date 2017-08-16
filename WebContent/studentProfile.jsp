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
</head>
<body>
<jsp:include page="studentHeader.jsp"></jsp:include>
<% 
if(session.getAttribute("studentId")==null){
	response.sendRedirect("studentLogin.jsp");
}
%>
<section id="main-content">
	<section class="wrapper">
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.*" %>
<%@page import="java.io.*" %>
<%
int stu_id=(int)session.getAttribute("studentId"); 
Connection con=null;
Statement stm=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryinfo","root","jatinj@615");
	stm=con.createStatement();
	ResultSet rs=stm.executeQuery("select * from student where student_id="+stu_id+";");
	rs.next();
%>
	<div class="form-w3layouts">
<h2 class="w3ls_head">Profile Info</h2>
<img src="uploads/<%=rs.getString("profile_pic") %>" height=200px width=200px align="right" style="border-radius:50%">
Name : <p><%=rs.getString("first_name")+" "+rs.getString("last_name") %></p>
Id : <p><%=rs.getInt("student_id") %></p>
UserName : <p><%=rs.getString("username") %></p>
Email : <p><%=rs.getString("email") %></p>
Phone No. : <p><%=rs.getString("contact") %></p>
<%
}catch(Exception e){
	out.print(e);
}
%>
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