package prj1;

public class Ex13 {
	public static void main(String[] args) {
		// 객체 생성 > 객체.메소드
		String str = "1234";
		Integer i = new Integer("111111");
		int a = i.parseInt(str);
		System.out.println(a);
		
		// 예외 : static 메소드는 클래스.메소드로 사용 가능
		int b = Integer.parseInt(str);
		System.out.println(b);
	}//main
}//end
