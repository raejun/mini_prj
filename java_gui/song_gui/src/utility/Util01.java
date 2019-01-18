package utility;
import java.util.*;
public class Util01 {
	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt();//-21억 ~21억
		int b = a % 100; // 100으로 나눳을때 나머지
		int c = Math.abs(b);
		System.out.println(c);
		
		int d = r.nextInt(100);//0-99
		System.out.println(d);
		
		int e = r.nextInt(45)+1;//1-45
		System.out.println(e);
	}//main
}//end
