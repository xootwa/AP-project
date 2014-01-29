
public class ArmBand {

	private Date sDate;
	private Date eDate;
	private int colour;
	private String code;
	
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public int getColour() {
		return colour;
	}
	public void setColour(int colour) {
		this.colour = colour;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArmBand(Date sDate, Date eDate, int colour, String code) {
		super();
		this.sDate = sDate;
		this.eDate = eDate;
		this.colour = colour;
		this.code = code;
	}
	
	public ArmBand(){
		sDate= new Date();
		eDate= new Date();
		colour=0;
		code="";
	}
	
}
