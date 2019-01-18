package utility;
import java.util.*;
public class Util03 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance(); // ΩÃ±€≈Ê ∆–≈œ
		Calendar c2 = Calendar.getInstance();
		System.out.println(c);
		System.out.println(c2);
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		System.out.println(hour + "Ω√ " + min + "∫–");
	}//main
}//end
