package utility;
import java.util.*;
public class Util07 {
	public static void main(String[] args) {
		String str = "hello Java world";
		StringTokenizer st = new StringTokenizer(str);
		int count = st.countTokens();
		System.out.println("��ū�� ���� "+count);
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
	}

}
