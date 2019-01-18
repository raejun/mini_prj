package prj1234;
	
public class Subway {
	String station1;  
	String station2;
	int number;
	
	public Subway(String station1, String station2, int number) {
		System.out.println(station1 +"에서 "+station2+"까지 "
				+ number+"개 입니다");
	}
	
	void play() {
		System.out.println("잠실나루역");
	}
	void sleep() {
		System.out.println("잠실나루역입니다");
	}
	public static void main(String[] args) {
		Subway mySubway = new Subway("잠실나루역","서초역",9);
		mySubway.sleep();
	}
}