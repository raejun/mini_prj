package Project;

public class MemberDTO {
	private String rname;
	private String menu;
	private String location;
	private String tel;
	private int price;
	// Getters and Setters
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MemberDTO [rname=" + rname + ", menu=" + menu + ", location=" + location + ", tel=" + tel + ", price="
				+ price + "]";
	}
	
}//end
