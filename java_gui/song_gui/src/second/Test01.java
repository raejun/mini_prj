package second;
import prj1234.Ex16;
public class Test01 {
	public static void main(String[] args) {
		Ex16 bike= new Ex16(100,"삼천리",25);
		//bike.brand 는 에러
		//이유는 다른 패키지에서는 EX16의 protected 변수에 접근 불가함
		//다른 패키지에서는 EX16의 protected 변수는 private화 됨
		//자식 클래스에서는 Ex16의 protected 변수는 public화 됨
	}//main
}//end
