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
			}//while : 로또 숫자 6개
			// 합계 관련 코드
			int sum = 0;
			for (Integer i : lotto) {
				sum += i;
			}//for : 합계
			if(sum >= 100 && sum <= 170) {
				System.out.println(lotto); // 로또 번호 출력
				count++; // 100 ~ 170 일 때만 카운트 증가
			}//if : 100 ~ 170
		}// while : 5게임
	}//main
}//end