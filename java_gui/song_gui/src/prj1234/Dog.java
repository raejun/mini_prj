package prj1234;
	
public class Dog {
	//변수
	String name;  //자료형 변수
	String kind;
	int age;
	//생성자
	public Dog(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
		System.out.println("종류는 "
				+ this.kind+",age="+this.age+"실행됨!");
	}
	//매소드, 동사
	void play() {
		System.out.println("강아지");
	}
	void sleep() {
		System.out.println("개");
	}
	public static void main(String[] args) {
		Dog myDog = new Dog("초롱이","허스키",5); //클래스 객체명 = new 생성자로
		myDog.sleep();
	}
}
