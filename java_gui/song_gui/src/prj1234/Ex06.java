package prj1234;
import java.util.*;
public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("첫번째 숫자 입력");
		int first = sc.nextInt();
		System.out.print("연산기호 입력[+ - * /]");
		String op = sc.next();
		System.out.print("두번째 숫자 입력");
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
			System.out.print("+-*만 입력할수 잇음");
		}
		System.out.println("결과는:"+result);

	}

}
