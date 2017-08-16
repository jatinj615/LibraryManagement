package addLibrarian;
import java.sql.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connections;

/**
 * Servlet implementation class AddLibrarian
 */
@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String contact=request.getParameter("contact");
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			int i=stm.executeUpdate("insert into librarian(name,password,email,address,city,contact) values('"+name+"','"+pass+"','"+email+"','"+address+"','"+city+"','"+contact+"');");
			if(i==1) {
				out.print("<script>window.location=\"adminDashboard.jsp\";alert(\"Librarian Added Successfully\");</script>");
			}
			connection.dbClose(null, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}

}
