package prj1;
public class Dog {
	// 변수, 명사
	String name;  // 자료형  변수명;
	String kind;
	int age;
	// 인자가 있는 생성자
	public Dog(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
		System.out.println("종류는 " 
				+ this.kind + "이고 나이는 " + this.age + "세인 강아지 "
				+ this.name + " 생성됨!!!");
	}
	// 메소드, 동사
	void play() {
		System.out.println("강아지 " + this.name + "가 놉니다!");
	}
	void sleep() {
		System.out.println("강아지 " + this.name + "가 잡니다!");
	}
	public static void main(String[] args) {
		Dog myDog = new Dog("뽀삐", "푸들", 5); // 클래스 객체명 = new 생성자 로 만든다.
		myDog.sleep();  // 객체.메소드 로 사용
	}// main
}// end
