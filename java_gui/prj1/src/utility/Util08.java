package utility;
import java.util.*;
public class Util08 {
	public static void main(String[] args) {
		// 중복X, 정렬X
		HashSet set = new HashSet();
		set.add("Hello");
		set.add("Java");
		set.add("World");
		set.add("Java"); // 이미 "Java"가 저장되어 있기 때문에 중복 저장되지 않는다.
		System.out.println(set); // [Java, Hello, World]
		Iterator a = set.iterator();
		while(a.hasNext()) {
			String str = (String) a.next();
			System.out.println(str);
		}//while
	}//main
}//end
