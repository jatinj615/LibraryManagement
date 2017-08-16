package returnBook;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connections;
import issueBook.Issue;

import java.io.*;
/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		response.setContentType("text/html");
		String book_Cn=request.getParameter("book_cn");
		String book_Id=request.getParameter("book_id");
		int student_Id=Integer.parseInt(request.getParameter("student_id"));
		Connection con=null;
		Statement stm1=null;
		Statement stm2=null;
		Statement stm3=null;
		Statement stm4=null;
		PrintWriter out=response.getWriter();	
		if(Return.check(book_Cn,book_Id,student_Id)) {
			try {
				con=connection.getConnection();
				stm1=con.createStatement();
				stm2=con.createStatement();
				stm3=con.createStatement();
				stm4=con.createStatement();
				int quantity=Issue.available(book_Cn)+1;
				int issued=Issue.issued(book_Cn)-1;
				ResultSet rs=stm1.executeQuery("select issue_date from issuebook where book_callno='"+book_Cn+"' and student_id="+student_Id+" and book_id='"+book_Id+"';");
				rs.next();
				int record=stm2.executeUpdate("insert into issuebook_history(book_id,book_callno,student_id,issue_date,return_date) values ('"+book_Id+"','"+book_Cn+"',"+student_Id+",'"+rs.getDate("issue_date")+"',now());");
				int check1=stm3.executeUpdate("delete from issuebook where book_callno='"+book_Cn+"' and book_id='"+book_Id+"' and student_id="+student_Id+"");
				int check2=stm4.executeUpdate("update books set quantity="+quantity+",issued="+issued+" where callno='"+book_Cn+"';");
				if(record==1 && check1==1 && check2==1)
					out.print("<script>window.location=\"returnBook.jsp\";alert(\"Book Returned Successfully..!\");</script>");
				connection.dbClose(null, stm4, null);
				connection.dbClose(null, stm3, null);
				connection.dbClose(null, stm2, null);
				connection.dbClose(null, stm1, con);
			}catch(Exception e) {
				System.out.println(e);
			}
			out.close();
		}else
			out.print("<script>window.location=\\\"returnBook.jsp\\\";alert(\"Something Went Wrong..!\");</script>");
	}

}
