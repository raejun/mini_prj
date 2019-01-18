package prj1;
public class Ex14 {
	private String name;
	private String email;
	// 우클릭 > source > Generate Getters and Setters > Select All > OK
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static void main(String[] args) {
		Ex14 obj = new Ex14();
		obj.setName("홍길동"); // name 에 "홍길동"을 셋팅, setter
		System.out.println(obj.getName()); // 홍길동, getter
		System.out.println(obj.name); // 나 자신의 private 변수에는 접근 가능
	}//main
}//end
