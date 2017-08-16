package librarianForgotPassword;

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
 * Servlet implementation class LibrarianOtpVerification
 */
@WebServlet("/LibrarianOtpVerification")
public class LibrarianOtpVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		PrintWriter out=response.getWriter();
		String email=(String)request.getSession(false).getAttribute("librarianEmail");
		out.print(email);
		int otp=Integer.parseInt(request.getParameter("otp"));
		Connection con=null;
		Statement stm=null;
	
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select name,id from librarian where otp="+otp+" and email='"+email+"';");
			if(rs.next()) {
				String name=rs.getString("name");
				int librarian_id=rs.getInt("id");
				Statement stm2=con.createStatement();
				int i=stm2.executeUpdate("update librarian set otp=null where id='"+librarian_id+"';");
				if(i==1) {
				HttpSession librarianSession=request.getSession(false);
				librarianSession.setAttribute("librarianName", name);
				response.sendRedirect("resetLibrarianPassword.jsp");
				}
			}
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}
}
