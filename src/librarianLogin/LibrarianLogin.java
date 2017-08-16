package librarianLogin;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LibrarianLogin
 */
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		try {
		if(LoginDaoLibrarian.getName(email, pass) != null) {
			HttpSession librarianSession=request.getSession(true);
			librarianSession.setAttribute("librarianName", LoginDaoLibrarian.getName(email, pass));
			librarianSession.setAttribute("librarianId", LoginDaoLibrarian.getId(email, pass));
			response.sendRedirect("librarianDashboard.jsp");
		}
		else {
			out.println("<script>window.location=\"librarianLogin.jsp\";alert(\"Email or Password is Incorrect..!\");</script>");
		}
		}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}

}
