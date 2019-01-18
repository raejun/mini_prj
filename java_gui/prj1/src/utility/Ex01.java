package utility;
import java.util.*;
public class Ex01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			sum += v.get(i);
		}//for
		System.out.println(sum);
		int sum2 = 0;
		for (Integer i : v) {
			sum2 += i;
		}//for
		System.out.println(sum2);
	}//main
}//end
