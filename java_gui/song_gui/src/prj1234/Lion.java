package prj1234;
public class Lion extends Animal {
	@Override
	void move() {
		System.out.println("���ٴ�");
	}
	@Override
	void breath() {
		System.out.println("����");
	}
	@Override
	void eat() {
		System.out.println("��� ����");
	}
	public static void main(String[] args) {
		Lion a = new Lion();
		a.move();
		a.breath();
		a.eat();
	}//main
}//end
