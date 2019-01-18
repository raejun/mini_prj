package prj1234;
public class Lion extends Animal {
	@Override
	void move() {
		System.out.println("±â¾î´Ù´Ô");
	}
	@Override
	void breath() {
		System.out.println("¼û½°");
	}
	@Override
	void eat() {
		System.out.println("°í±â ¸ÔÀ½");
	}
	public static void main(String[] args) {
		Lion a = new Lion();
		a.move();
		a.breath();
		a.eat();
	}//main
}//end
