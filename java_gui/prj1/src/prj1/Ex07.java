package prj1;
import java.util.*;
public class Ex07 {
	public static void main(String[] args) {
		int hap = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("시작 숫자를 입력하세요");
		int begin = sc.nextInt();
		System.out.println("끝 숫자를 입력하세요");
		int end = sc.nextInt();
		for (int i = begin; i <= end; i++) {
			hap = hap + i;
		}//for
		System.out.println(begin + "~" + end + " 합=" + hap);
	}//main
}//end
