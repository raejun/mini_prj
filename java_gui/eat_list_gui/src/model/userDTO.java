package model;

public class userDTO {
	private String id;
	private String pw;
	private String name;
	private String mail;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userDTO [id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", name=");
		builder.append(name);
		builder.append(", mail=");
		builder.append(mail);
		builder.append("]");
		return builder.toString();
	}
}
