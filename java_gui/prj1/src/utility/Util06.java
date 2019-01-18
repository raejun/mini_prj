package utility;
import java.util.*;
public class Util06 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("hong", "홍길동"); // 예) (키) : (값) 형태, 아이디 : 이름
		map.put("jang", "장길산");
		map.put("im", "임꺽정");
		String str = (String) map.get("hong");
		System.out.println(str); // 홍길동
		// 복합적인 자료를 담고싶다.
		HashMap<String, Member> map2 = new HashMap<>();
		// 테스트할 Member 객체 생성
		Member m = new Member();
		m.setId("kim");
		m.setPw("1234");
		m.setName("김철수");
		// Member 객체를 "kim" 이라는 키로 담는다.
		map2.put("kim", m); // 키 : 값
		Member m2 = map2.get("kim"); // "kim" 이라는 키로 찾아서 Member 객체를 가져온다.
		System.out.println(m2); // Member [id=kim, pw=1234, name=김철수]
	}//main
}//end