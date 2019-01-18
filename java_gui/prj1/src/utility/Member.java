package utility;
// DTO(Data Transfer Object) : 데이터 담아서 이동에 사용하는 객체
public class Member {
	String id;
	String pw;
	String name;
	// 겟터와 셋터를 생성 : 우클릭 > source > Generate Getters and Setters > Select All > Generate
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
	// 우클릭 > source > Generate toString > Generate
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
}//end
