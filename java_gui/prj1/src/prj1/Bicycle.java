package prj1;
public class Bicycle extends Object {
	protected int id;
	protected String brand;
	public Bicycle() { } // �⺻ ������
	// ��Ŭ�� > source > Generate Constructor using fields > Generate 
	public Bicycle(int id, String brand) {
		this.id = id;
		this.brand = brand;
		System.out.println("������ Bicycle ����!!!");
	}
	// ��Ŭ�� > source > Generate toSting > Generate
	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", brand=" + brand + "]";
	}
	public static void main(String[] args) {
		Bicycle myBike = new Bicycle(200, "��õ��");
		System.out.println( "�귣��=" + myBike.toString() );
	}//main
}//end