package prj1234;
	
public class Drama {
	String title1;
	int year1;
	String title2;
	int year2;
	
	public Drama(String title1, int year1, String title2, int year2) {
		System.out.println(title1 +"�� "+year1+"�⵵ ��ǰ�̰� "+title2+"�� "
				+year2+"�⵵ ��ǰ�Դϴ�");
	}
	
	void play() {
		System.out.println("���νô�");
	}
	void sleep() {
		System.out.println("�Ż��� ǰ��");
	}
	public static void main(String[] args) {
		Drama myDrama = new Drama("���νô�",2002,"�Ż��� ǰ��",2012);
		myDrama.sleep();
	}
}