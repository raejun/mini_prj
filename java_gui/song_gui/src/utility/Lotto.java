package utility;
import java.util.*;
public class Lotto {
	public static void main(String[] args) {
		int count = 0;
		while(count<5) {
			Random r = new Random();
			TreeSet<Integer> lotto = new TreeSet();//중복ㄴㄴ 정렬ㅇㅇ
			while(lotto.size()<6) {
				lotto.add(r.nextInt(45)+1);
			}//while lotto
			int sum = 0;
			for (Integer i : lotto) {
				sum += i;
			}//for
			if(sum>=100 && sum<=170) {
				System.out.println(lotto);
				count++;//100-170일 때만 카운트 증가
			}else {
				System.out.println("참고 sum "+ sum);
			}//else
		}//while count
	}//main
}//end
