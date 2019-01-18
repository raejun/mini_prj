package prj1;
import java.util.*;
public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요");
		int first = sc.nextInt();
		System.out.println("기호를 입력하세요 [+ - * /]");
		String op = sc.next();
		System.out.println("두번째 숫자를 입력하세요");
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
				System.out.println("+ - * / 만 입력할 수 있습니다");
				break;
		}//switch
		System.out.println("결과는: " + result);
	}//main
}//end
