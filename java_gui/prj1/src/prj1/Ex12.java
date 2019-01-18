package prj1;
public class Ex12 {
	public static void main(String[] args) {
		// while 문 테스트
		// 1. 초기화
		int i = 1;
		int hap = 0;
		while(hap <= 10000) { // 2. 조건
			hap = hap + i;
			i++; // 3. 증감
		}//while
		System.out.println("i=" + i + ", hap=" + hap);
	}//main
}//end
