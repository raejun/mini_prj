package prj1;

public class Ex19 {
	public static final double PI = 3.141519; // 상수형 변수
	public double area(int r) {
		double a = r * r * PI;
		return a;
	}
	public static void main(String[] args) {
		Ex19 obj = new Ex19();
		// obj.PI = 1.5; // 에러 : 고칠 수 없다
		System.out.println("반지름 5인 원의 넓이=" + obj.area(5) );
	}//main
}//end
