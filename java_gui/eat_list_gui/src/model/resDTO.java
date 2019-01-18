package model;

public class resDTO {
	private String resName;
	private String address;
	private String tel;
	private String reprMenu;
	private int price;
	
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReprMenu() {
		return reprMenu;
	}
	public void setReprMenu(String reprMenu) {
		this.reprMenu = reprMenu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("resDTO [resName=");
		builder.append(resName);
		builder.append(", address=");
		builder.append(address);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", reprMenu=");
		builder.append(reprMenu);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
}
