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
 * Servlet implementation class GenerateMail
 */
@WebServlet("/GenerateMail")
public class GenerateMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		String email=request.getParameter("email");
		String from="";
		String pass="";
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select name from librarian where email='"+email+"';");
			if(rs.next()) {
				if(SendLibrarianMail.send(from,pass,email)) {
				HttpSession librarianSession=request.getSession(true);
				librarianSession.setAttribute("librarianEmail", email);
				response.sendRedirect("librarianOtpVerification.jsp");
				}
			}
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}

}
