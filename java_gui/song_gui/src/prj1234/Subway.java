package prj1234;
	
public class Subway {
	String station1;  
	String station2;
	int number;
	
	public Subway(String station1, String station2, int number) {
		System.out.println(station1 +"���� "+station2+"���� "
				+ number+"�� �Դϴ�");
	}
	
	void play() {
		System.out.println("��ǳ��翪");
	}
	void sleep() {
		System.out.println("��ǳ��翪�Դϴ�");
	}
	public static void main(String[] args) {
		Subway mySubway = new Subway("��ǳ��翪","���ʿ�",9);
		mySubway.sleep();
	}
}