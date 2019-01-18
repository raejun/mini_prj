package prj1;
public class Ex18 {
	public static void main(String[] args) {
		// 1. 객체.메소드 : 그냥 메소드
		String str = "10";
		Integer a = new Integer(1000);
		int b = a.parseInt(str);
		System.out.println("b=" + b); // 10

		// 2. 클래스.메소드 : static 메소드
		String str2 = "20";
		int c = Integer.parseInt(str2);
		System.out.println("c=" + c); // 20
	}//main
}//end
