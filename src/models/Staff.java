package models;

public abstract class Staff extends User{

	public Staff() {
		super();
	}

	public Staff(String id, String name, String password) {
		super(id, name, password);
	}
	
}
