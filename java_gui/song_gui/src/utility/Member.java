package utility;

//DTO(data transfer object 데이터 담는 객체)
public class Member {
	String id;
	String pw;
	String name;
	//게터와 세터 이용 우클릭 소스 제너레이트 세터게터
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

}
