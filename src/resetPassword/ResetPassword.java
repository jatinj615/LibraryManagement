package resetPassword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Connections;

import java.sql.*;
import java.io.*;
/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		String pass=request.getParameter("newPassword");
		String stu_username=(String)request.getSession().getAttribute("username");
		Connection con=null;
		Statement stm=null;
		Statement stm2=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			stm2=con.createStatement();
			int i=stm.executeUpdate("update student set password='"+pass+"' where username='"+stu_username+"';");
			ResultSet rs=stm2.executeQuery("select student_id from student where username='"+stu_username+"';");
			if(i==1) {
				rs.next();
				HttpSession studentSession=request.getSession(false);
				studentSession.setAttribute("studentId",rs.getInt("student_id"));
				out.print("<script>alert(\"Password Changed Successfully ..!\";</script>");
				response.sendRedirect("studentDashboard.jsp");
			}
			connection.dbClose(null, stm2, null);
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}

}
