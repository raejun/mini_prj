package prj1;
import java.util.*;
public class Ex07 {
	public static void main(String[] args) {
		int hap = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���ڸ� �Է��ϼ���");
		int begin = sc.nextInt();
		System.out.println("�� ���ڸ� �Է��ϼ���");
		int end = sc.nextInt();
		for (int i = begin; i <= end; i++) {
			hap = hap + i;
		}//for
		System.out.println(begin + "~" + end + " ��=" + hap);
	}//main
}//end
