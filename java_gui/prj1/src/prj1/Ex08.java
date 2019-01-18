package prj1;

public class Ex08 {
	public static void main(String[] args) {
		String jumin = "881011-1";
		//              01234567
		char c = jumin.charAt(7);
		// System.out.println("c=" + c);
		if(c == '1') {
			System.out.println("PC 용품 추천");
		} else {
			System.out.println("King's back 추천");
		}
	}//main
}//end
