package prj1;
public class Ex12 {
	public static void main(String[] args) {
		// while �� �׽�Ʈ
		// 1. �ʱ�ȭ
		int i = 1;
		int hap = 0;
		while(hap <= 10000) { // 2. ����
			hap = hap + i;
			i++; // 3. ����
		}//while
		System.out.println("i=" + i + ", hap=" + hap);
	}//main
}//end
