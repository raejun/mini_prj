package prj1234;
public class MountainBike extends Bicycle {
	String frame;
	boolean suspension;
	public MountainBike(int id, String brand, String frame, boolean suspension) {
		super(id, brand); //�θ��� �����ڸ� ȣ��
		this.frame=frame;
		this.suspension=suspension;
		System.out.println("������ MountainBike ����!!");
	}
	@Override
	public String toString() {
		return "MountainBike [frame=" + frame + ", suspension=" + suspension + ", id=" + id + ", brand=" + brand + "]";
	}
		public static void main(String[] args) {
		MountainBike bike= new MountainBike(100,"��õ��","�⺻������",true);
		// TODO Auto-generated method stub
		System.out.println(bike);
	}
}
