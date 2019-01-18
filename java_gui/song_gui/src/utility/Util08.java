package utility;
import java.util.*;
public class Util08 {
	public static void main(String[] args) {
		//set은 중복 정렬 ㄴㄴ
		HashSet set = new HashSet();
		set.add("hello");
		set.add("java");
		set.add("world");
		set.add("java");//이미 java가  저장되잇어서 중복저장 ㄴㄴ but 에러는 안뜸
		System.out.println(set);
		Iterator a = set.iterator();
		while(a.hasNext()) {
			String str = (String) a.next();
			System.out.println(str);
		}
	}
}
