package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	//3. to store create variable of Connection 
	private static Connection con=null;
	
	// for direct call use static
	public static Connection createConnection() throws SQLException {
		
		
		
		try {
			// 1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. create connection
			String user= "root";
			String pass = "root";
			String url = "jdbc:mysql://localhost:3306/jdbc";
			con = DriverManager.getConnection(url, user, pass);
			
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		// connection return catch ke bahar
		return con;
		
	}
	

}
