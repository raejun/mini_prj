package prj1234;
import java.util.*;
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요:");
		int a = sc.nextInt();
		int result = a % 2;
		if(result==0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}

	}

}
