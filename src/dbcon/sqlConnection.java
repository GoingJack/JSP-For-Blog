package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlConnection {
	private static Connection conn = null;
	public static Connection getCon() { 
		try { 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String user = "sa"; 
			String pwd = "1"; 
			String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MyDatabase"; 
			conn = DriverManager.getConnection(url, user, pwd); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		return conn;
	}

}
