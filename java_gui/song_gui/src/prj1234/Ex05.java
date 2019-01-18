package prj1234;
import java.util.*;
public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		int a = sc.nextInt();
		int b = (a-1)/10;
		if(b==9) {
			System.out.println("ㄱ");
		}else if(b==8) {
			System.out.println("ㄴ");
		}else if(b==7) {
			System.out.println("ㄷ");
		}else if(b==6) {
			System.out.println("ㄹ");
		}else 
			System.out.println("ㅋ");
//		if(a>90) {
//		System.out.println("A");
//		}else if (91>a & a>80) {
//			System.out.println("B");
//		}else if(81>a & a>70) {
//			System.out.println("C");
//		}else if(71>a & a>60) {
//			System.out.println("D");
//		}else 
//			System.out.println("F");
		}

	}

