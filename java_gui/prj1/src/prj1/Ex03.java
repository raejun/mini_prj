package prj1;
public class Ex03 {
	public static void main(String[] args) {
		String str = "";
		int age = 19;
		if (age > 18) {
			str = "�����Դϴ�";
		} else {
			str = "�̼����Դϴ�";
		}
		System.out.println(str);
		
		String str2 = (age > 18) ? "����" : "�̼���";
		//            ����               ? ���϶�_�� : �����϶�_��
		System.out.println(str2);
	}//main
}//end
