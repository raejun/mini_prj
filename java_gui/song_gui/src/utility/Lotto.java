package utility;
import java.util.*;
public class Lotto {
	public static void main(String[] args) {
		int count = 0;
		while(count<5) {
			Random r = new Random();
			TreeSet<Integer> lotto = new TreeSet();//�ߺ����� ���Ĥ���
			while(lotto.size()<6) {
				lotto.add(r.nextInt(45)+1);
			}//while lotto
			int sum = 0;
			for (Integer i : lotto) {
				sum += i;
			}//for
			if(sum>=100 && sum<=170) {
				System.out.println(lotto);
				count++;//100-170�� ���� ī��Ʈ ����
			}else {
				System.out.println("���� sum "+ sum);
			}//else
		}//while count
	}//main
}//end
