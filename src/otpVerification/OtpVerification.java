package otpVerification;

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
 * Servlet implementation class OtpVerification
 */
@WebServlet("/OtpVerification")
public class OtpVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		String username=(String)request.getSession(false).getAttribute("username");
		int otp=Integer.parseInt(request.getParameter("otp"));
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select first_name,student_id from student where otp="+otp+" and username='"+username+"';");
			if(rs.next()) {
				String firstName=rs.getString("first_name");
				int stu_id=rs.getInt("student_id");
				Statement stm2=con.createStatement();
				int i=stm2.executeUpdate("update student set otp=null where student_id='"+stu_id+"';");
				if(i==1) {
				HttpSession studentSession=request.getSession(false);
				studentSession.setAttribute("studentName", firstName);
				response.sendRedirect("resetPassword.jsp");
				}
				connection.dbClose(rs, stm2, con);
			}
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}


}
