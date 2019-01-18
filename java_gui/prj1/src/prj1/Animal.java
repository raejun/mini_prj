package prj1;

public abstract class Animal {
	// 추상 메소드
	abstract void move();
	abstract void eat();

	// 일반 메소드
	void breath() {
		System.out.println("숨쉰다!!!");
	}
}//end
