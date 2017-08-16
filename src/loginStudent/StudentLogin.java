package loginStudent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		try {
		if(LoginDaoStudent.getName(username, pass) != null) {
			HttpSession studentSession=request.getSession(true);
			studentSession.setAttribute("studentName", LoginDaoStudent.getName(username, pass));
			studentSession.setAttribute("studentId", LoginDaoStudent.getId(username, pass));
			response.sendRedirect("studentDashboard.jsp");
		}
		else {
			out.println("<script>window.location=\"studentLogin.jsp\";alert(\"Email or Password is Incorrect..!\");</script>");
		}}catch(Exception e) {
			out.print(e);
		}
		out.close();
	}

}
