package utility;
import java.util.*;
public class Util05 {
	public static void main(String[] args) {
		// generic, 제네릭을 사용 하기 전
		Vector v = new Vector(); // 자바 1.4 방식
		v.add("콜라");
		v.add("콜라");
		v.add(new Date()); // 이 시점에는 에러가 안난다.
		// 반복문으로 얻을 때 에러 발생
		/*
		for(int i = 0; i < v.size(); i++) {
			String str = (String) v.get(i);
			System.out.println(str);
		}//for
		*/
		// generic, 제네릭을 사용 후
		Vector<String> v2 = new Vector<>();
		v2.add("콜라");
		v2.add("콜라");
		// v2.add(new Date()); // 컴파일 오류
	}//main
}//end
