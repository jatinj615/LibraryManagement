package studentRegister;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connections;

import java.io.*;
/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		String first_Name=request.getParameter("stu_firstname");
		String last_Name=request.getParameter("stu_lastname");
		String email=request.getParameter("stu_email");
		String contact=request.getParameter("stu_contact");
		String username=request.getParameter("stu_username");
		String password=request.getParameter("stu_password");
		int stu_id=0;
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		if(!Registration.check(email,contact)){
			try {
			con=connection.getConnection();
			stm=con.createStatement();
			if(Registration.getId()!=0)
				stu_id = Registration.getId();
			int i=stm.executeUpdate("insert into student(student_id,first_name,last_name,email,username,password,contact,status) values("+stu_id+",'"+first_Name+"','"+last_Name+"','"+email+"','"+username+"','"+password+"','"+contact+"',"+1+")");
			if(i==1) {
				request.setAttribute("registered", true);
				request.setAttribute("email", email);
				request.setAttribute("contact", contact);
				request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
			}
			connection.dbClose(null, stm, con);
			}catch(Exception e) {
			out.print(e);
		}
	}
		else {
			if(Registration.getStatus(email, contact)==1) {
			request.setAttribute("registered", false);
			request.setAttribute("email", email);
			request.setAttribute("contact", contact);
			request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
			}
			else {
				out.print("<script>window.location=\"activateStudent.jsp\";alert(\"User Account was Deactivated..!\");</script>");
			}
		}

	}
}
