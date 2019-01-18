package prj1234;
import java.util.*;
public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("시작 숫자 입력");
		int first = sc.nextInt();
		System.out.print("끝 숫자 입력");
		int second = sc.nextInt();
		sc.close();
		int hap = 0;
		for(int i=first; i<=second; i++) {
			hap=hap+i;
		}
		System.out.println("합 = "+hap);

	}

}
