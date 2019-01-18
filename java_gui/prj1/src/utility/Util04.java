package utility;
import java.util.*;
public class Util04 {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("=== 초기화 상태의 벡터 ===");
		System.out.println("v.size()=" + v.size()); // 0
		System.out.println("v.capacity()=" + v.capacity()); // 10
		for (int i = 0; i < 9; i++) {
			v.add( i ); // v.add( new Integer(i) ); // 오토박싱
		}//for
		System.out.println("=== 9개 저장후 벡터 ===");
		System.out.println("v.size()=" + v.size()); // 9
		System.out.println("v.capacity()=" + v.capacity()); // 10
		System.out.println(v); // [0, 1, 2, 3, 4, 5, 6, 7, 8]
		v.add(9);  // capacity=10
		System.out.println(v); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		v.add(10); // capacity=20
		System.out.println("=== 11개 저장후 벡터 ===");
		System.out.println("v.size()=" + v.size()); // 11
		System.out.println("v.capacity()=" + v.capacity()); // 20
		System.out.println(v);
	}//main
}//end
