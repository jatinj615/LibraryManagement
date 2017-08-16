package connection;

import java.sql.*;
public class Connections {
	public java.sql.Connection getConnection() throws Exception{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryinfo","root","");
				return con;
			}catch(Exception e) {
				System.out.println(e);
				throw new Exception("Server Is Down");
			}
	}
	public void dbClose(ResultSet rs,Statement stm,Connection con) {
		try{
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		}
		catch(SQLException e) { e.printStackTrace();}
	}
	public void dbClose(ResultSet rs,PreparedStatement ps,Connection con) {
		try{
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		catch(SQLException e) { e.printStackTrace();}
	}
}
