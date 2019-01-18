package prj1234;

public class Apt {
	String name;
	String elec;
	static String park;

	public Apt(String name, String elec) {
		this.name=name;
		this.elec=elec;
	}
	public static void main(String[]args) {
		Apt kang = new Apt("강호동","냉장고");
		Apt yoo = new Apt("유재석","tv");
		kang.park="쓰레기 투기";
		System.out.println("yoo.park= "+yoo.park);
	}

}
