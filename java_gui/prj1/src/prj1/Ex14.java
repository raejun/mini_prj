package prj1;
public class Ex14 {
	private String name;
	private String email;
	// ��Ŭ�� > source > Generate Getters and Setters > Select All > OK
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
		obj.setName("ȫ�浿"); // name �� "ȫ�浿"�� ����, setter
		System.out.println(obj.getName()); // ȫ�浿, getter
		System.out.println(obj.name); // �� �ڽ��� private �������� ���� ����
	}//main
}//end
