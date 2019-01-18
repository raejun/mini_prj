package prj1234;
public class OverLoadingExam {
	//매소드 오버로딩 - 매소드명은 같고 파라미터의 갯수 또는 자료형이 다른거
	// 정수 2개를 더하는 매소드 정의
	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
	//실수 2개를 더하는 매소드 정의
	// public 변환되는 자료형 매소드명(인수1_자료형 변수, 인수2_자료형 변수)
	public double add(double a, double b) {
		double c = a + b;
		return c;
	}
	public static void main(String[] args) {
		OverLoadingExam obj = new OverLoadingExam();
		System.out.println("1+2 = "+obj.add(1,2));
		System.out.println("1.4+2.3 = "+obj.add(1.4,2.3));
		}//main
}//end
