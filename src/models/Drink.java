package models;

import java.sql.Connection;
import java.sql.SQLException;

public class Drink {
	public final static double MIN_PRICE = 500.0;
	public final static String TYPES[] = {"Alcoholic", "Non-Alcoholic"};
	
	private double price;
	private String name;
	private int type;
	
	public Drink(String drinkName, int drinkType, Double drinkPrice) {
		super();
		this.name = drinkName;
		this.type = drinkType;
		this.price = drinkPrice;
	}
	
	public Drink(){
		price=0;
		name="drink";
		type=0;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public boolean save() throws SQLException{
		Connection conn = DBConnect.getConnection();
		if(conn.prepareStatement("INSERT INTO drinks(name, price, type) VALUES ('" + this.name + "', '" + this.price + "', '" + this.type + "')").executeUpdate() > 0){
			System.out.println("Drink "+this.name+" was inserted successfully!");
			return true;
		}
		return false;
	}
}
