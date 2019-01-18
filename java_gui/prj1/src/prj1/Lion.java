package prj1;
public class Lion extends Animal {
	@Override
	void move() {
		System.out.println("살금살금 움직인다.");
	}
	@Override
	void eat() {
		System.out.println("사냥해서 먹는다.");
	}
	public static void main(String[] args) {
		Lion a = new Lion();
		a.move();
		a.eat();
	}//main
}//end
