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
		Apt kang = new Apt("��ȣ��","�����");
		Apt yoo = new Apt("���缮","tv");
		kang.park="������ ����";
		System.out.println("yoo.park= "+yoo.park);
	}

}
