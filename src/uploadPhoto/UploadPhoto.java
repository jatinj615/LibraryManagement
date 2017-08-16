package uploadPhoto;

import java.io.*;
import java.sql.DriverManager;
import java.util.*;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import connection.Connections;

import java.sql.*;
 

/**
 * Servlet implementation class UploadPhoto
 */
@WebServlet("/UploadPhoto")
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connections connection=new Connections();
		int stu_id=(int) request.getSession(false).getAttribute("studentId");
		int maxThreshold=1024*1024*10;
		int maxFileSize=1024*1024*10;
		boolean isMultipart;
		File file;
		PrintWriter out=response.getWriter();
		Connection con=null;
		Statement stm=null;
//		 String applicationPath = request.getServletContext().getRealPath("");
//		 String directory="uploads";
//		 String uploadPath=applicationPath+directory; 
		String uploadPath="/home/jatin/eclipse-workspace/LibraryProject/WebContent/uploads/";
		isMultipart = ServletFileUpload.isMultipartContent(request);
	     response.setContentType("text/html");
	     if(isMultipart) { 
	     DiskFileItemFactory factory = new DiskFileItemFactory();
	   
	      factory.setSizeThreshold(maxThreshold);
	      factory.setRepository(new File(uploadPath));
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      upload.setSizeMax( maxFileSize );
	      try { 
	         List fileItems = upload.parseRequest(request);
	         Iterator i = fileItems.iterator();
	         while ( i.hasNext () ) {
	            FileItem fi = (FileItem)i.next();
	            if ( !fi.isFormField () ) {
	               String fileName = fi.getName();
	               if( fileName.lastIndexOf("\\") >= 0 ) {
	            	   fileName=fileName.substring( fileName.lastIndexOf("\\"));
	               } else {
	            	   fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
	               }
	               if(fileName.length()>20)
	            	   fileName=fileName.substring(fileName.length()-20, fileName.length());
	                  file = new File( uploadPath +File.separator+ fileName) ;
	               fi.write( file ) ;
	               con=connection.getConnection();
	               stm=con.createStatement();
	               int check=stm.executeUpdate("update student set profile_pic='"+fileName+"' where student_id="+stu_id+";");
	               if(check==1) {
	            	   out.print("<script>window.location=\"studentSettings.jsp\";alert(\"Photo uploaded Successfully ..!\");</script>");
	               }
	            }
	         }
	         connection.dbClose(null, stm, con);
	         } catch(Exception ex) {
	            out.println(ex);
	         }
	      }
	}
}
