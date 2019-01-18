package utility;
import java.util.Vector;
public class Ex01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
//방법 1
		int sum=0;
		for(int i =0; i<v.size(); i++) {
			sum +=v.get(i);
		}
		System.out.println(sum);
//방법 2 (요게 더 조음)	
		int sum2=0;
		for(Integer i : v) {
			sum2+=i;
		}
		System.out.println(sum2);
	}//main
}//end
