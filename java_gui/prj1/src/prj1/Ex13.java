package prj1;

public class Ex13 {
	public static void main(String[] args) {
		// ��ü ���� > ��ü.�޼ҵ�
		String str = "1234";
		Integer i = new Integer("111111");
		int a = i.parseInt(str);
		System.out.println(a);
		
		// ���� : static �޼ҵ�� Ŭ����.�޼ҵ�� ��� ����
		int b = Integer.parseInt(str);
		System.out.println(b);
	}//main
}//end
