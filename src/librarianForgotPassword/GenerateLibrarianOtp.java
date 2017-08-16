package librarianForgotPassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import connection.Connections;

public class GenerateLibrarianOtp {
	public static int code(String email) {
		int otp;
		Connections connection=new Connections();
		Random uniqueId=new Random();
		Connection con=null;
		Statement stm=null;
		otp=1000+uniqueId.nextInt(8999);
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			stm.executeUpdate("update librarian set otp="+otp+" where email='"+email+"';");
			connection.dbClose(null, stm, con);
		}catch(Exception e) {
			System.out.print(e);
		}
		return otp;
	}

}
