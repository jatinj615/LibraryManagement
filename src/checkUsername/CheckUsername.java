package checkUsername;
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
 * Servlet implementation class CheckUsername
 */
@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsername() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection =new Connections();
		String username=request.getParameter("usr_name");
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		if(username.length()>0) {
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select id from student where username='"+username+"';");
			if(rs.next()) {
					 out.println("<font color=red>");
		             out.println("Already taken..");
		             out.println("</font>");
				}
			else {
				 out.println("<font color=green>");
	             out.println("Available");
	             out.println("</font>");
			}
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		}else {
			 out.println("<font color=red>");
	            out.println("Username can not be Empty..!");
	            out.println("</font>");
		}
		out.close();
	}

}
