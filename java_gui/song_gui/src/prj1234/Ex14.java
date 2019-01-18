package prj1234;
public class Ex14 {
	private String name;
	private String email;
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
		Ex14 obj=new Ex14();
		obj.setName("せせせ"); //name拭 せせせ研 実特 , setter
		System.out.println(obj.getName());
		System.out.println(obj.email);
	}
}
