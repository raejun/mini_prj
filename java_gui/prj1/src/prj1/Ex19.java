package prj1;

public class Ex19 {
	public static final double PI = 3.141519; // ����� ����
	public double area(int r) {
		double a = r * r * PI;
		return a;
	}
	public static void main(String[] args) {
		Ex19 obj = new Ex19();
		// obj.PI = 1.5; // ���� : ��ĥ �� ����
		System.out.println("������ 5�� ���� ����=" + obj.area(5) );
	}//main
}//end
