package prj1;
public class Dog {
	// ����, ���
	String name;  // �ڷ���  ������;
	String kind;
	int age;
	// ���ڰ� �ִ� ������
	public Dog(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
		System.out.println("������ " 
				+ this.kind + "�̰� ���̴� " + this.age + "���� ������ "
				+ this.name + " ������!!!");
	}
	// �޼ҵ�, ����
	void play() {
		System.out.println("������ " + this.name + "�� ��ϴ�!");
	}
	void sleep() {
		System.out.println("������ " + this.name + "�� ��ϴ�!");
	}
	public static void main(String[] args) {
		Dog myDog = new Dog("�ǻ�", "Ǫ��", 5); // Ŭ���� ��ü�� = new ������ �� �����.
		myDog.sleep();  // ��ü.�޼ҵ� �� ���
	}// main
}// end
