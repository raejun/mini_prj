package prj1234;

public class Ex19 {
	public static final double PI=3.141592; //상수형 변수
	public double area(int r) {
		double a = (r^2)*PI;
		return a;
	}
	public static void main(String[] args) {
		Ex19 obj=new Ex19();
		//obj.PI=1.5; 요거는 에러 - 고칠수 없음
		System.out.println("반지름이 5인 원의 넓이는 "+obj.area(5));
	}
}
