package utility;
import java.util.*;
public class Util01 {
	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt(); // -21�� ~ + 21��
		int b = a % 100; // -99 ~ +99
		int c = Math.abs(b); // 0 ~ 99
		System.out.println(c);
		
		int d = r.nextInt(100); // 0 ~ 99
		System.out.println(d);
		
		// �ζ� : 1 ~ 45
		int e = r.nextInt(45) + 1;
		System.out.println(e);
	}//main
}//end
