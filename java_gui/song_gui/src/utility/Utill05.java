package utility;
import java.util.*;
public class Utill05 {
	public static void main(String[] args) {
		//generic ����ϱ� ��
		Vector v= new Vector();
		v.add("�ݶ�");
		v.add("�ݶ�");
		v.add("new Date()");
		//�ݺ������� ���� �� ���� �߻�
		/*
		for(int i =0; i < v.size(); i++) {
			String str = (String)v.get(i);
			System.out.println(str);
		}//for
		*/
		//generic ��� ��
		Vector<String> v2= new Vector<>();
		v2.add("�ݶ�");
		v2.add("�ݶ�");
		v2.add(new Date());//������ ����
		
	}

}
