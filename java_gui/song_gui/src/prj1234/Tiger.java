package prj1234;
	
public class Tiger {
	String name;  
	String nickname;
	int age;
	
	public Tiger(String name, String nickname, int age) {
		System.out.println("호랑이의 이름은 "+ name +"이고"+" 별명은 "+nickname
				+ " 나이는"+age);
	}
	
	void play() {
		System.out.println("호랑이");
	}
	void sleep() {
		System.out.println("호랑이");
	}
	public static void main(String[] args) {
		Tiger myTiger = new Tiger("호랭이","돼랑이",5);
		myTiger.sleep();
	}
}