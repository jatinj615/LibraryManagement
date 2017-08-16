package addBooks;
import java.sql.*;

import connection.Connections;
public class Books {
public static int getQuantity(String b_cn) {
	Connections connection=new Connections();
	int quantity=0;
	Connection con=null;
	Statement stm=null;
	try {
		con=connection.getConnection();
		stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select quantity from books where callno='"+b_cn+"';");
		if(rs.next())
			quantity=rs.getInt("quantity");
		connection.dbClose(rs, stm, con);
	}catch(Exception e) {
		System.out.println(e);
	}
	return quantity;
}
}
