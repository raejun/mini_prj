package prj1;

public class Calcurator {
	// static 메소드 예제
	public static int add(int a, int b) {
		return a + b;
	}
	public static void main(String[] args) {
		int c = Calcurator.add(100, 200);
		System.out.println("100 + 200 =" + c);
	}//main
}//end
