package Third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseConnection {
	
	private static Connection con;
	
	public static Connection getCon() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
	}
}

