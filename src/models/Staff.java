package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Staff extends User{

	public Staff() {
		super();
	}

	public Staff(String id, String name, String password) {
		super(id, name, password);
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public static boolean login(String username, String password) throws SQLException{
		
		try {
			// Access JDBC driver from JAR 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		// Connect to DB
		Connection con = DriverManager.getConnection(Constants.DB, Constants.DB_USER, Constants.DB_PASS);
		// Query staff table
		PreparedStatement checkStaff = con.prepareStatement("SELECT * FROM staff WHERE name = '" + username + "' AND password = '" + password + "'");
		// Variable to execute query
		ResultSet result = checkStaff.executeQuery();
			
		/*  
		 * Check for user occurrence in staff table:
		 */
		int count = 0;
		while(result.next())
			++count;
		if(count == 1)
			return true;
		
		
		return false;
	}
	
}
