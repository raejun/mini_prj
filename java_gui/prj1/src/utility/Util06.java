package utility;
import java.util.*;
public class Util06 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("hong", "ȫ�浿"); // ��) (Ű) : (��) ����, ���̵� : �̸�
		map.put("jang", "����");
		map.put("im", "�Ӳ���");
		String str = (String) map.get("hong");
		System.out.println(str); // ȫ�浿
		// �������� �ڷḦ ���ʹ�.
		HashMap<String, Member> map2 = new HashMap<>();
		// �׽�Ʈ�� Member ��ü ����
		Member m = new Member();
		m.setId("kim");
		m.setPw("1234");
		m.setName("��ö��");
		// Member ��ü�� "kim" �̶�� Ű�� ��´�.
		map2.put("kim", m); // Ű : ��
		Member m2 = map2.get("kim"); // "kim" �̶�� Ű�� ã�Ƽ� Member ��ü�� �����´�.
		System.out.println(m2); // Member [id=kim, pw=1234, name=��ö��]
	}//main
}//end