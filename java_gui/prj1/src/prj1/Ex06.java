package prj1;
import java.util.*;
public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ���ڸ� �Է��ϼ���");
		int first = sc.nextInt();
		System.out.println("��ȣ�� �Է��ϼ��� [+ - * /]");
		String op = sc.next();
		System.out.println("�ι�° ���ڸ� �Է��ϼ���");
		int second = sc.nextInt();
		int result = 0;
		switch (op) {
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
				System.out.println("+ - * / �� �Է��� �� �ֽ��ϴ�");
				break;
		}//switch
		System.out.println("�����: " + result);
	}//main
}//end
