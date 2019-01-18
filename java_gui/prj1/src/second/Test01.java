package second;
import prj1.Ex16;
public class Test01 {
	public static void main(String[] args) {
		Ex16 bike = new Ex16(100, "삼천리", 20);
		// bike.brand 는 에러
		// 이유 : 다른 패키지에서는 prj1.Ex16 의 protected 변수에 접근 불가
		// 다른 패키지에서는 prj1.Ex16 의 protected 변수는 private 화 된다.
		// 자식 클래스에서는 prj1.Ex16 의 protected 변수는 public 화 된다.
	}//main
}//end
