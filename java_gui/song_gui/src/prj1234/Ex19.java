package prj1234;

public class Ex19 {
	public static final double PI=3.141592; //����� ����
	public double area(int r) {
		double a = (r^2)*PI;
		return a;
	}
	public static void main(String[] args) {
		Ex19 obj=new Ex19();
		//obj.PI=1.5; ��Ŵ� ���� - ��ĥ�� ����
		System.out.println("�������� 5�� ���� ���̴� "+obj.area(5));
	}
}
