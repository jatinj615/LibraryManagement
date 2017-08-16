package returnBook;
import java.sql.*;

import connection.Connections;
public class Return {
	public static boolean check(String b_cn,String b_id,int s_id) {
		boolean status=false;
		Connections connection=new Connections();
		Connection con=null;
		Statement stm=null;
		try {
			con=connection.getConnection();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from issuebook where book_callno='"+b_cn+"' and book_id='"+b_id+"' and student_id="+s_id+";");
			if(rs.next())	
				status=true;
			connection.dbClose(rs, stm, con);
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
