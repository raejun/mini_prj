package prj1234;

public class Hw01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "go";
		int b = a.length();
		System.out.println(b);
		
		String c = "gogo";
		String d=c.replace("o", "g");
		System.out.println(d);
		
		String e ="go go";
		String[] f = e.split(" ");
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i]);
		}
		
		String g ="gogo";
		String h=g.substring(1,3);
		System.out.println(h);
		
		String i ="GOGO";
		String j= i.toLowerCase();
		System.out.println(j);
	}
}
