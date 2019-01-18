package utility;
import java.util.*;
public class Lotto {
	public static void main(String[] args) {
		int count = 0;
		while(count < 5) {
			Random r = new Random();
			TreeSet<Integer> lotto = new TreeSet<>();
			while(lotto.size() < 6) {
				lotto.add(r.nextInt(45) + 1);
			}//while : �ζ� ���� 6��
			// �հ� ���� �ڵ�
			int sum = 0;
			for (Integer i : lotto) {
				sum += i;
			}//for : �հ�
			if(sum >= 100 && sum <= 170) {
				System.out.println(lotto); // �ζ� ��ȣ ���
				count++; // 100 ~ 170 �� ���� ī��Ʈ ����
			}//if : 100 ~ 170
		}// while : 5����
	}//main
}//end