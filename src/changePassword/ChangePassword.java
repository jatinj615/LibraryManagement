package changePassword;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Connections;

import java.io.*;
/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection= new Connections();
		response.setContentType("text/html");
		int id=(int) request.getSession(false).getAttribute("studentId");
		String current_password=request.getParameter("current_password");
		String new_password=request.getParameter("new_password");
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select password from student where student_id="+id+";");
			rs.next();
			if(current_password.equals(rs.getString("password"))){
				Statement stm2=null;
				stm2=con.createStatement();
				int i=stm2.executeUpdate("update student set password='"+new_password+"' where student_id="+id+";");
				if(i==1) {
					out.println("<script>window.location=\"studentDashboard.jsp\";alert(\"Password Changed Successfully...\")</script>");
				connection.dbClose(null, stm2, null);
				}
			}
			else {
				out.println("<script>window.location=\"studentSettings.jsp\";alert(\"Password Entered is Incorrect...\")</script>");
			}
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}
}
