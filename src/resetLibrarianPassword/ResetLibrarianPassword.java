package resetLibrarianPassword;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Connections;

/**
 * Servlet implementation class ResetLibrarianPassword
 */
@WebServlet("/ResetLibrarianPassword")
public class ResetLibrarianPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		String pass=request.getParameter("newPassword");
		String email=(String)request.getSession().getAttribute("librarianEmail");
		Connection con=null;
		Statement stm=null;
		Statement stm2=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			stm2=con.createStatement();
			int i=stm.executeUpdate("update librarian set password='"+pass+"' where email='"+email+"';");
			ResultSet rs=stm2.executeQuery("select id from librarian where email='"+email+"'");
			if(i==1) {
				rs.next();
				HttpSession librarianSession=request.getSession(false);
				librarianSession.setAttribute("librarianId", rs.getInt("id"));
				out.print("<script>alert(\"Password Changed Successfully ..!\";</script>");
				response.sendRedirect("librarianDashboard.jsp");
			}
			connection.dbClose(null, stm2, null);
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}
	}
