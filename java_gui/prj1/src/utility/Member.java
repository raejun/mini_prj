package utility;
// DTO(Data Transfer Object) : ������ ��Ƽ� �̵��� ����ϴ� ��ü
public class Member {
	String id;
	String pw;
	String name;
	// ���Ϳ� ���͸� ���� : ��Ŭ�� > source > Generate Getters and Setters > Select All > Generate
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
	// ��Ŭ�� > source > Generate toString > Generate
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
}//end
