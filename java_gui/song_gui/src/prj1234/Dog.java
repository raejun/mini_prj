package prj1234;
	
public class Dog {
	//����
	String name;  //�ڷ��� ����
	String kind;
	int age;
	//������
	public Dog(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
		System.out.println("������ "
				+ this.kind+",age="+this.age+"�����!");
	}
	//�żҵ�, ����
	void play() {
		System.out.println("������");
	}
	void sleep() {
		System.out.println("��");
	}
	public static void main(String[] args) {
		Dog myDog = new Dog("�ʷ���","�㽺Ű",5); //Ŭ���� ��ü�� = new �����ڷ�
		myDog.sleep();
	}
}
