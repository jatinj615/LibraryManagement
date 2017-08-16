package librarianLogin;

import java.sql.*;

import connection.Connections;
public class LoginDaoLibrarian {
 public static String getName(String email,String pass) {
	 Connections connection=new Connections();
	 String name=null;
	 Connection con=null;
	 Statement stm=null;
	 try {
			con=connection.getConnection();
		 	stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select name from librarian where email='"+email+"' and password='"+pass+"';");
			if(rs.next()) {
				name=rs.getString("name");
				}
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			System.out.print(e);
		}
	 return name;
 }
 public static int getId(String email,String pass) {
	 int id=0;
	 Connections connection=new Connections();
	 Connection con=null;
	 Statement stm=null;
	 try {
			con=connection.getConnection();
		 	stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select id from librarian where email='"+email+"' and password='"+pass+"';");
			if(rs.next()) {
				id=rs.getInt("id");
				}
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			System.out.print(e);
		}
	 return id;
 }
}
