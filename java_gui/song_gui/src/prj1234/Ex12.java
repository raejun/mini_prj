package prj1234;

public class Ex12 {

	public static void main(String[] args) {
		// while 문 테스트
		int i =1;
		int sum = 0;
		while(sum<=10000) {    //조건
			sum = sum + i;   
			i++;       //증감
		}
		System.out.println(i);
		System.out.println(sum);

	}

}
