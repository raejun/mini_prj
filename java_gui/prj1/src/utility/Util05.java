package utility;
import java.util.*;
public class Util05 {
	public static void main(String[] args) {
		// generic, ���׸��� ��� �ϱ� ��
		Vector v = new Vector(); // �ڹ� 1.4 ���
		v.add("�ݶ�");
		v.add("�ݶ�");
		v.add(new Date()); // �� �������� ������ �ȳ���.
		// �ݺ������� ���� �� ���� �߻�
		/*
		for(int i = 0; i < v.size(); i++) {
			String str = (String) v.get(i);
			System.out.println(str);
		}//for
		*/
		// generic, ���׸��� ��� ��
		Vector<String> v2 = new Vector<>();
		v2.add("�ݶ�");
		v2.add("�ݶ�");
		// v2.add(new Date()); // ������ ����
	}//main
}//end
