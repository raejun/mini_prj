package utility;
import java.util.*;
public class Util08 {
	public static void main(String[] args) {
		//set�� �ߺ� ���� ����
		HashSet set = new HashSet();
		set.add("hello");
		set.add("java");
		set.add("world");
		set.add("java");//�̹� java��  ������վ �ߺ����� ���� but ������ �ȶ�
		System.out.println(set);
		Iterator a = set.iterator();
		while(a.hasNext()) {
			String str = (String) a.next();
			System.out.println(str);
		}
	}
}
