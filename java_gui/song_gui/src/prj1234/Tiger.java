package prj1234;
	
public class Tiger {
	String name;  
	String nickname;
	int age;
	
	public Tiger(String name, String nickname, int age) {
		System.out.println("ȣ������ �̸��� "+ name +"�̰�"+" ������ "+nickname
				+ " ���̴�"+age);
	}
	
	void play() {
		System.out.println("ȣ����");
	}
	void sleep() {
		System.out.println("ȣ����");
	}
	public static void main(String[] args) {
		Tiger myTiger = new Tiger("ȣ����","�Ŷ���",5);
		myTiger.sleep();
	}
}