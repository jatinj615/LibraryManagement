package loginStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.Connections;

public class LoginDaoStudent {
	 public static String getName(String username,String pass) {
		 Connections connection=new Connections();
		 String name=null;
		 Connection con=null;
		 Statement stm=null;
		 try {
				con=connection.getConnection();
			 	stm=con.createStatement();
				ResultSet rs=stm.executeQuery("select first_name,status from student where username='"+username+"' and password='"+pass+"';");
				if(rs.next()) {
					if(rs.getInt("status")==1)
					name=rs.getString("first_name");
					}
				connection.dbClose(rs, stm, con);
			}catch(Exception e) {
				System.out.print(e);
			}
		 return name;
	 }
	 public static int getId(String username,String pass) {
		 Connections connection=new Connections();
		 int id=0;
		 Connection con=null;
		 Statement stm=null;
		 try {
				con=connection.getConnection();
			 	stm=con.createStatement();
				ResultSet rs=stm.executeQuery("select student_id from student where username='"+username+"' and password='"+pass+"';");
				if(rs.next()) {
					id=rs.getInt("student_id");
					}
				connection.dbClose(rs, stm, con);
			}catch(Exception e) {
				System.out.print(e);
			}
		 return id;
	 }
}
