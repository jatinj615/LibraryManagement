package forgotPasswordOtp;
import java.sql.*;
import java.util.Random;

import connection.Connections;

public class GenerateOtp {
		public static int code(String username) {
			int otp;
			Connections connection=new Connections();
			Random uniqueId=new Random();
			Connection con=null;
			Statement stm=null;
			otp=1000+uniqueId.nextInt(8999);
			try {
				con=connection.getConnection();
				stm=con.createStatement();
				stm.executeUpdate("update student set otp="+otp+" where username='"+username+"';");
				connection.dbClose(null, stm, con);
			}catch(Exception e) {
				System.out.print(e);
			}
			return otp;
		}
}
