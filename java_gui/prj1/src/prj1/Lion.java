package prj1;
public class Lion extends Animal {
	@Override
	void move() {
		System.out.println("��ݻ�� �����δ�.");
	}
	@Override
	void eat() {
		System.out.println("����ؼ� �Դ´�.");
	}
	public static void main(String[] args) {
		Lion a = new Lion();
		a.move();
		a.eat();
	}//main
}//end
