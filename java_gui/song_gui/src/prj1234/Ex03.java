package prj1234;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		int age = 19;
		
		if(age>18) {
			str="성인입니다";
		} else {str="미성년입니다";}
		System.out.println(str);
		
		String str2=(age>18) ? "성인":"미성년";
		System.out.println(str2);
	}//main

}//end
