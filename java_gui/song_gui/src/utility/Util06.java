package utility;
import java.util.*;
public class Util06 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("hong", "ȫ�浿");
		map.put("jang", "����");
		map.put("im", "�Ӳ���");
		String str = (String) map.get("hong");
		System.out.println(str);
		
		HashMap<String, Member> map2 = new HashMap<>();
		Member m = new Member();
		m.setId("kim");
		m.setPw("1234");
		m.setName("��c");
		map2.put("kim", m);
		Member m2= map2.get("kim");
		System.out.println(m2.name);
	}

}
