package deactivateStudent;
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
 * Servlet implementation class DeactivateStudent
 */
@WebServlet("/DeactivateStudent")
public class DeactivateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		Connection con=null;
		Statement stm=null;
		int id=(int) request.getSession(false).getAttribute("studentId");
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			int i=stm.executeUpdate("update student set status="+0+" where student_id="+id+";");
			if(i==1) {
				out.print("<script>window.location=\"studentLogin.jsp\";alert(\"Account Deactivated Successfully..\")</script>");
			}
			connection.dbClose(null, stm, con);
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}
}
