package deleteLibrarian;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connections;

/**
 * Servlet implementation class DeleteLibrarian
 */
@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		response.setContentType("text/html");
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			int i=stm.executeUpdate("delete from librarian where id="+id+";");
			if(i==1) {
				out.print("<script>window.location=\"adminDashboard.jsp\";alert(\"Librarian Deleted Successfully\");</script>");
			}
			else
				out.print("<script>window.location=\"deleteLibrarian.jsp\";alert(\"Id Entered is not Correct..!\");</script>");
			connection.dbClose(null, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
	}
}
