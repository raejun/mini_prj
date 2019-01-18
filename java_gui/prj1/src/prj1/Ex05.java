package prj1;
import java.util.*;
public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성적을 입력하세요:");
		int score = sc.nextInt();
		int jumsu = (score -1) / 10;
		System.out.println("jumsu=" + jumsu);
		if(jumsu == 9) { // 91 92 93 94 95 96 97 98 99 100
			System.out.println("A학점!");
		} else if(jumsu == 8) { // 81 82 83 84 85 86 87 88 89 90
			System.out.println("B학점!");
		} else if(jumsu == 7) {
			System.out.println("C학점!");
		} else if(jumsu == 6) {
			System.out.println("D학점!");
		} else if(jumsu >= 0 && jumsu <= 5) {
			System.out.println("F학점!");
		} else {
			System.out.println("0 ~ 100 사이의 성적을 입력하세요!");
		}
//		if(score >= 91 && score <= 100) {
//			System.out.println("A학점!");
//		} else if(score >= 81 && score <= 90) {
//			System.out.println("B학점!");
//		} else if(score >= 71 && score <= 80) {
//			System.out.println("C학점!");
//		} else if(score >= 61 && score <= 70) {
//			System.out.println("D학점!");
//		} else if(score >= 0 && score <= 60) {
//			System.out.println("F학점!");
//		} else {
//			System.out.println("0 ~ 100 사이의 성적을 입력하세요!");
//		}
	}//main
}//end
