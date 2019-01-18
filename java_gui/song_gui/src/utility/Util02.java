package utility;
import java.text.SimpleDateFormat;
import java.util.*;
public class Util02 {
	public static void main(String[] args) { 
		Date today = new Date();
		String pattern= "yyy년 mm월 dd일 hh시 mm분 ss초";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String strDate = dateFormat.format(today);
		System.out.println(strDate);
	}//main
}//end
