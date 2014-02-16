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
	
	/*
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
