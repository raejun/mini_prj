package prj1;
public class MoutainBike extends Bicycle {
	String frame;
	boolean suspension;
	public MoutainBike(int id, String brand, String frame, boolean suspension) {
		super(id, brand); // 부모의 생성자를 호출, 예: Bicycle(id, brand) 을 호출
		this.frame = frame;
		this.suspension = suspension;
		System.out.println("생성자 MoutainBike 실행!!!");
	}
	// 우클릭 > source > Generate toSting > Generate
	@Override  // 오버라이딩
	public String toString() {
		return "MoutainBike [frame=" + frame + ", suspension=" + suspension 
				+ ", id=" + id + ", brand=" + brand + "]";
	}
	public static void main(String[] args) {
		MoutainBike bike = new MoutainBike(100, "삼천리", "카본 프레임", true);
		System.out.println( bike.toString() );
	}//main
}//end