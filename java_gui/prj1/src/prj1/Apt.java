package prj1;
public class Apt {
	String name;
	String elec;
	static String park; // 공유
	public Apt(String name, String elec) {
		this.name = name;
		this.elec = elec;
	}//생성자
	public static void main(String[] args) {
		Apt kang = new Apt("강호동", "냉장고");
		Apt yoo = new Apt("유재석", "TV");
		kang.park = "쓰레기 버려짐";
		System.out.println("yoo.park=" + yoo.park);
		System.out.println("kang=" + kang);
	}//main
}//end
