package prj1;
import java.util.*;
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ���:");
		int a = sc.nextInt();
		int result = a % 2;
		if(result == 0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}
	}//main
}//end
