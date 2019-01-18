package prj1234;

public class Ex13 {

	public static void main(String[] args) {
		// 객체생성 - 객체.매소드
		String str = "1234";
		Integer i = new Integer("930125");
		int a = i.parseInt(str);
		System.out.println(a);
		
		//static 매소드는 클래스, 매소드로 사용 가능
		int b= Integer.parseInt(str);
		System.out.println(b);
	}
}
