
public class Staff {
	private String id;
	private String name;
	private String hours;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	
	public Staff(String id, String name, String hours) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
	}
	
	public Staff(){
		id="";
		name="";
		hours="";
	}

}
