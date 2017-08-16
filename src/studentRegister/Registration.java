package studentRegister;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

import connection.Connections;

public class Registration {
	public static boolean check(String stu_email,String stu_contact) {
		Connections connection =new Connections();
		boolean status=false;
		Connection con=null;
		Statement stm=null;
		try {
		con=connection.getConnection();
		stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select status from student where email='"+stu_email+"' and contact='"+stu_contact+"'");
		if(rs.next()) {
			status=true;
		}
		connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			System.out.print(e);
		}
		return status;
	}
	public static int getId(){
		int id=0;
		Connections connection=new Connections();
		Random uniqueId=new Random();
		int count=1;
		Connection con=null;
		Statement stm=null;
		while(true) {
			for(count=1;count<2;count++) {
				id=10000+uniqueId.nextInt(89999);
			}
			try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select username from student where student_id="+id+";");
			if(rs.next())
				count=1;
			else
				break;
			connection.dbClose(rs, stm, con);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return id;
	}
	public static int getStatus(String stu_email,String stu_contact) {
		int status=0;
		Connections connection=new Connections();
		Connection con=null;
		Statement stm=null;
		try {
		con=connection.getConnection();
		stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select status from student where email='"+stu_email+"' and contact='"+stu_contact+"'");
		if(rs.next()) {
			if(rs.getInt("status")==0) {
				status=0;
			}
			if(rs.getInt("status")==1) {
				status=1;
			}
		}
		connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			System.out.print(e);
		}
		return status;
	}
}
