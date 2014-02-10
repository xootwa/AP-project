
public class Drink {
	// this comment
	private double price;
	private String name;
	private int type;
	
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
	public Drink(){
		price=0;
		name="drink";
		type=0;
	}
	public Drink(double price, String name, int type) {
		super();
		this.price = price;
		this.name = name;
		this.type = type;
	}
	
	
}
