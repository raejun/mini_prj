package prj1234;

public class Ex18 {

	public static void main(String[] args) {
		//1. 객체.매소드 - 걍 매소드
		Integer a = new Integer(125);
		String str = "10";
		int b = a.parseInt(str);
		System.out.println("b = "+b);
		
		//2. 클래스.매소드 - static 매소드
		String str2="20";
		int c = Integer.parseInt(str2);
		System.out.println("c = "+c);

	}

}
