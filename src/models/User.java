package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class User {
	protected String id;
	protected String name;
	protected String password;
	
	public User(){
		this.id = Constants.NO_ID;
		this.name = Constants.NO_NAME;
		this.password = Constants.NO_PASSWORD;
	}
	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public static boolean login(String username, String password){
		try {
			// Access JDBC driver from JAR 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		try {
			// Connect to DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap-project", "root", "");
			// Query
			PreparedStatement statement = con.prepareStatement("select * from staff");
			// Variable to execute query
			ResultSet result = statement.executeQuery();
			
			/* TODO 
			 * Remove test while:
			 */
			while(result.next()){
				System.out.println(result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return false;
	}
	
	
	
	/**
	 *  PR:
	 *  Protected constants for use with users
	 */
	protected static final class Constants{
		public static final String DB = "";
		
		public static final String NO_ID = null;
		public static final String NO_NAME = null;
		public static final String NO_PASSWORD = "default";
		
	}
	
}
