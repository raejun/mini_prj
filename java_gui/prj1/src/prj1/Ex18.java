package prj1;
public class Ex18 {
	public static void main(String[] args) {
		// 1. ��ü.�޼ҵ� : �׳� �޼ҵ�
		String str = "10";
		Integer a = new Integer(1000);
		int b = a.parseInt(str);
		System.out.println("b=" + b); // 10

		// 2. Ŭ����.�޼ҵ� : static �޼ҵ�
		String str2 = "20";
		int c = Integer.parseInt(str2);
		System.out.println("c=" + c); // 20
	}//main
}//end
