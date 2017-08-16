package addBooks;

import java.io.IOException;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connections;

/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		response.setContentType("text/html");
		String book_Cn=request.getParameter("book_cn");
		String book_Name=request.getParameter("book_name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		Connection con=null;
		Statement stm=null;
		PrintWriter out=response.getWriter();
		try {
			con=connection.getConnection();
			stm=con.createStatement();
		if(Books.getQuantity(book_Cn)>0) {
			int q=Books.getQuantity(book_Cn)+quantity;
			int i=stm.executeUpdate("update books set quantity="+q+",added_date=now() where callno='"+book_Cn+"';");
			if(i==1) {
				out.print("<script>window.location=\"addBooks.jsp\";alert(\"Books Updated Successfully\");</script>");
			}
		}else {
			int i=stm.executeUpdate("insert into books(callno,name,author,publisher,quantity,added_date) values('"+book_Cn+"','"+book_Name+"','"+author+"','"+publisher+"',"+quantity+",now());");
			if(i==1) {
				out.print("<script>window.location=\"addBooks.jsp\";alert(\"Books Added Successfully\");</script>");
				
			}
		}
		connection.dbClose(null, stm, con);
	}catch(Exception e) {
		out.println(e);
	}
		out.close();
		}
}
