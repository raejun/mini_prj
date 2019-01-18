package prj1234;
public class Bicycle {
	protected int id;
	protected String brand;
	public Bicycle() {}
	public Bicycle(int id, String brand) {
		this.id = id;
		this.brand = brand;
		System.out.println("ㅋㅋㅋ");
	}
	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", brand=" + brand + "]";
	}
	public static void main(String[] args) {
		Bicycle mybike = new Bicycle(200, "BMW");
		System.out.println("브랜드는 "+mybike.toString());
	}

}
