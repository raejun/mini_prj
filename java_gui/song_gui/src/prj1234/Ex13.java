package prj1234;

public class Ex13 {

	public static void main(String[] args) {
		// ��ü���� - ��ü.�żҵ�
		String str = "1234";
		Integer i = new Integer("930125");
		int a = i.parseInt(str);
		System.out.println(a);
		
		//static �żҵ�� Ŭ����, �żҵ�� ��� ����
		int b= Integer.parseInt(str);
		System.out.println(b);
	}
}
