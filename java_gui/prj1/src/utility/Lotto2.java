package utility;
import java.util.*;
public class Lotto2 {
	public static void main(String[] args) {
		int count = 0;
		while(count < 5) {
			List<Integer> balls = new ArrayList<>();
			for(int i = 1; i <= 45; i++) {
				balls.add(i);
			}//for : 1 ~ 45 공 생성
			Collections.shuffle(balls); // 섞는다.
			List<Integer> lotto = balls.subList(0, 6); // index 0, 1, 2, 3, 4, 5 : 6개
			Collections.sort(lotto); // 정렬
			int sum = 0;
			for (Integer i : lotto) {
				sum += i;
			}//for
			if(sum >= 100 && sum <= 170) {
				System.out.println(lotto);
				count++;
			}
		}// while : 5게임
	}//main
}//end