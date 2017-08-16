
<% 
String name=(String)session.getAttribute("librarianName");
if( session.getAttribute("librarianId")==null){
	response.sendRedirect("librarianLogin.jsp");
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
                <span class="username" style="padding-left:8px;"> Welcome <%=name %></span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="librarianLogout.jsp"><i class="fa fa-key"></i> Log Out</a></li>
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
                    <a href="addBooks.jsp">
                        <i class="fa fa-book"></i>
                        <span>Add Books</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="viewBooks.jsp">
                        <i class="fa fa-book"></i>
                        <span>Books In Library</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="studentRegister.jsp">
                        <i class="fa fa-book"></i>
                        <span>Student Registration</span>
                    </a>
                </li>
                 <li class="sub-menu">
                    <a href="activateStudent.jsp">
                        <i class="fa fa-book"></i>
                        <span>Activate Student Account</span>
                    </a>
                  <li class="sub-menu">
                    <a href="issueBooks.jsp">
                        <i class="fa fa-book"></i>
                        <span>Issue Books</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="viewIssuedBooks.jsp">
                        <i class="fa fa-book"></i>
                        <span>View Issued Books</span>
                    </a>
                </li>
                  <li class="sub-menu">
                    <a href="returnBook.jsp">
                        <i class="fa fa-book"></i>
                        <span>Return Book</span>
                    </a>
                </li>
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
</section>