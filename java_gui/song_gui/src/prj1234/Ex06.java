package prj1234;
import java.util.*;
public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("ù��° ���� �Է�");
		int first = sc.nextInt();
		System.out.print("�����ȣ �Է�[+ - * /]");
		String op = sc.next();
		System.out.print("�ι�° ���� �Է�");
		int second = sc.nextInt();
		int result = 0;
		switch(op) {
		case "+":
			result = first + second;
			break;
		case "-":
			result = first - second;
			break;
		case "*":
			result = first * second;
			break;
		case "/":
			result = first / second;
			break;
		default:
			System.out.print("+-*�� �Է��Ҽ� ����");
		}
		System.out.println("�����:"+result);

	}

}
