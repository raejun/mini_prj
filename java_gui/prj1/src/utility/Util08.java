package utility;
import java.util.*;
public class Util08 {
	public static void main(String[] args) {
		// �ߺ�X, ����X
		HashSet set = new HashSet();
		set.add("Hello");
		set.add("Java");
		set.add("World");
		set.add("Java"); // �̹� "Java"�� ����Ǿ� �ֱ� ������ �ߺ� ������� �ʴ´�.
		System.out.println(set); // [Java, Hello, World]
		Iterator a = set.iterator();
		while(a.hasNext()) {
			String str = (String) a.next();
			System.out.println(str);
		}//while
	}//main
}//end
