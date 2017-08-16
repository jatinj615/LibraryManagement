package issueBook;
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
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection = new Connections();
		response.setContentType("text/html");
		String book_Cn=request.getParameter("book_cn");
		String book_Id=request.getParameter("book_id");
		int student_Id=Integer.parseInt(request.getParameter("student_id"));
		String student_Name=request.getParameter("student_firstName");
		String student_Contact=request.getParameter("student_contact");
		Connection con=null;
		Statement stm1=null;
		Statement stm2=null;
		PrintWriter out=response.getWriter();
		if(Issue.studentCheck(student_Id,student_Name,student_Contact)) {
			if(Issue.available(book_Cn)>0) {
				try {
					con=connection.getConnection();
					int quantity=Issue.available(book_Cn)-1;
					int issued=Issue.issued(book_Cn)+1;
					stm1=con.createStatement();
					stm2=con.createStatement();
					int check1=stm1.executeUpdate("insert into issuebook(book_callno,book_id,student_id,student_name,student_contact,issue_date) values ('"+book_Cn+"','"+book_Id+"',"+student_Id+",'"+student_Name+"','"+student_Contact+"',now());");
					int check2=stm2.executeUpdate("update books set quantity="+quantity+",issued="+issued+" where callno='"+book_Cn+"';");
					if(check1==1 && check2==1)
						out.print("<script>window.location=\"issueBooks.jsp\";alert(\"Book Issued Successfully..!\");</script>");
					connection.dbClose(null, stm2, null);
					connection.dbClose(null, stm1, con);
				}catch(Exception e) {
					out.println(e);
				}
			}
			else
				out.print("<script>window.location=\"issueBooks.jsp\";alert(\"Book Not Available at this Time..!\");</script>");
		}
		else
			out.print("<script>window.location=\"issueBooks.jsp\";alert(\"Student Not Registered..!\");</script>");
		out.close();
	}
	
}
