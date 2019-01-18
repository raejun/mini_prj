package prj1;
public class Bicycle extends Object {
	protected int id;
	protected String brand;
	public Bicycle() { } // 기본 생성자
	// 우클릭 > source > Generate Constructor using fields > Generate 
	public Bicycle(int id, String brand) {
		this.id = id;
		this.brand = brand;
		System.out.println("생성자 Bicycle 실행!!!");
	}
	// 우클릭 > source > Generate toSting > Generate
	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", brand=" + brand + "]";
	}
	public static void main(String[] args) {
		Bicycle myBike = new Bicycle(200, "삼천리");
		System.out.println( "브랜드=" + myBike.toString() );
	}//main
}//end