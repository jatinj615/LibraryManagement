package issueBook;
import java.sql.*;

import connection.Connections;
public class Issue {
	public static boolean studentCheck(int s_id,String s_name,String s_contact) {
		Connections connection = new Connections();
		boolean status=false;
		Connection con=null;
		Statement stm=null;
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select status from student where student_id="+s_id+" and first_name='"+s_name+"' and contact='"+s_contact+"';");
			if(rs.next())
				status=true;
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int available(String b_cn) {
		int quantity=0;
		Connection con=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryinfo","root","jatinj@615");
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select quantity from books where callno='"+b_cn+"';");
			if(rs.next())
				quantity=rs.getInt("quantity");
		}catch(Exception e) {
			System.out.println(e);
		}
		return quantity;
	}
	public static int issued(String b_cn) {
		int quantity=0;
		Connection con=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryinfo","root","jatinj@615");
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select issued from books where callno='"+b_cn+"';");
			if(rs.next())
				quantity=rs.getInt("issued");
		}catch(Exception e) {
			System.out.println(e);
		}
		return quantity;
	}
}
