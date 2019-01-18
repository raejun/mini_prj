package prj1234;
	
public class Drama {
	String title1;
	int year1;
	String title2;
	int year2;
	
	public Drama(String title1, int year1, String title2, int year2) {
		System.out.println(title1 +"은 "+year1+"년도 작품이고 "+title2+"은 "
				+year2+"년도 작품입니다");
	}
	
	void play() {
		System.out.println("야인시대");
	}
	void sleep() {
		System.out.println("신사의 품격");
	}
	public static void main(String[] args) {
		Drama myDrama = new Drama("야인시대",2002,"신사의 품격",2012);
		myDrama.sleep();
	}
}