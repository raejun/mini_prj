package prj1234;
import java.util.*;
public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("���� ���� �Է�");
		int first = sc.nextInt();
		System.out.print("�� ���� �Է�");
		int second = sc.nextInt();
		sc.close();
		int hap = 0;
		for(int i=first; i<=second; i++) {
			hap=hap+i;
		}
		System.out.println("�� = "+hap);

	}

}
