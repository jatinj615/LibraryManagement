<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String name=(String)session.getAttribute("studentName");
if(session.getAttribute("studentId")==null){
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
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
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
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="studentProfile.jsp"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="studentSettings.jsp"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="studentLogout.jsp"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a href="studentDashboard.jsp">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                   <li class="sub-menu">
                    <a href="studentAvailableBooks.jsp">
                        <i class="fa fa-book"></i>
                        <span>Available Books In Library</span>
                    </a>
                </li>
                <!--  <li class="sub-menu">
                    <a href="requestBook.jsp">
                        <i class="fa fa-book"></i>
                        <span>Request for book</span>
                    </a>
                </li> -->
                <li class="sub-menu">
                    <a href="studentIssuedBooks.jsp">
                        <i class="fa fa-book"></i>
                        <span>Currently Issued Books</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="issueHistory.jsp">
                        <i class="fa fa-book"></i>
                        <span>Issued Books Record</span>
                    </a>
                </li>
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
</section>
