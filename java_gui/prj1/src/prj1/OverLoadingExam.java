package prj1;
public class OverLoadingExam {
	// �޼ҵ� �����ε� : �޼ҵ���� ���� �Ķ������ ���� �Ǵ� �ڷ����� Ʋ�� ��
	// ���� 2���� ���ϴ� �޼ҵ� ����
	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
	// �Ǽ� 2���� ���ϴ� �޼ҵ� ����
	// public  ��ȯ�Ǵ�_�ڷ���  �޼ҵ��(�μ�1_�ڷ���  ����, �μ�2_�ڷ���  ����) { ... }
	public double add(double a, double b) {
		double c = a + b;
		return c;
	}
	public static void main(String[] args) {
		OverLoadingExam obj = new OverLoadingExam();
		System.out.println("1 + 2 = " + obj.add(1, 2) );
		System.out.println("1.4 + 2.3 = " + obj.add(1.4, 2.3) );
	}//main
}//end
