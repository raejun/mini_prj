package utility;
import java.util.*;
public class Util07 {
	public static void main(String[] args) {
		String str = "hello Java world";
		StringTokenizer st = new StringTokenizer(str);
		int count = st.countTokens();
		System.out.println("토큰의 수는 "+count);
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
	}

}
