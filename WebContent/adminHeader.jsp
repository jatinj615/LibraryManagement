<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
if(session==null || session.getAttribute("adminName")==null){
	response.sendRedirect("adminLogin.jsp");
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
                <span class="username" style="padding-left:8px;"> Welcome Admin</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="adminLogout.jsp"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
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
                    <a href="librarianDashboard.jsp">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="addLibrarian.jsp">
                        <i class="fa fa-book"></i>
                        <span>Add Librarian</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="viewLibrarian.jsp">
                        <i class="fa fa-book"></i>
                        <span>Librarians In Library</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="deleteLibrarian.jsp">
                        <i class="fa fa-book"></i>
                        <span>Delete Librarian</span>
                    </a>
                  </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
</section>
