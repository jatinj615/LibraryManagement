package activateStudent;
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
 * Servlet implementation class ActivateStudent
 */
@WebServlet("/ActivateStudent")
public class ActivateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		String email=request.getParameter("student_email");
		String contact=request.getParameter("student_contact");
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			int i=stm.executeUpdate("update student set status="+1+" where email='"+email+"' and contact='"+contact+"';");
			if(i==1) {
				out.print("<script>alert(\"Student Activated Successfully...!\")</script>");
				request.setAttribute("email", email);
				request.setAttribute("contact", contact);
				request.getRequestDispatcher("studentInfo.jsp").forward(request,response);
			connection.dbClose(null, stm, con);
			}
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
		}
}
