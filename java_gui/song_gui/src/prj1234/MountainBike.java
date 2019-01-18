package prj1234;
public class MountainBike extends Bicycle {
	String frame;
	boolean suspension;
	public MountainBike(int id, String brand, String frame, boolean suspension) {
		super(id, brand); //부모의 생성자를 호출
		this.frame=frame;
		this.suspension=suspension;
		System.out.println("생성자 MountainBike 실행!!");
	}
	@Override
	public String toString() {
		return "MountainBike [frame=" + frame + ", suspension=" + suspension + ", id=" + id + ", brand=" + brand + "]";
	}
		public static void main(String[] args) {
		MountainBike bike= new MountainBike(100,"삼천리","기본프레임",true);
		// TODO Auto-generated method stub
		System.out.println(bike);
	}
}
