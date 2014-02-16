public class Guest extends User {
	
	private String code;
	private ArmBand band;
	
	public Guest(String name, String code, ArmBand band) {
		super();
		this.name = name;
		this.code = code;
		this.band = band;
	}	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArmBand getBand() {
		return band;
	}
	public void setBand(ArmBand band) {
		this.band = band;
	}
	
}
