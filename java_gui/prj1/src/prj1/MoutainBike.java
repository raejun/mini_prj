package prj1;
public class MoutainBike extends Bicycle {
	String frame;
	boolean suspension;
	public MoutainBike(int id, String brand, String frame, boolean suspension) {
		super(id, brand); // �θ��� �����ڸ� ȣ��, ��: Bicycle(id, brand) �� ȣ��
		this.frame = frame;
		this.suspension = suspension;
		System.out.println("������ MoutainBike ����!!!");
	}
	// ��Ŭ�� > source > Generate toSting > Generate
	@Override  // �������̵�
	public String toString() {
		return "MoutainBike [frame=" + frame + ", suspension=" + suspension 
				+ ", id=" + id + ", brand=" + brand + "]";
	}
	public static void main(String[] args) {
		MoutainBike bike = new MoutainBike(100, "��õ��", "ī�� ������", true);
		System.out.println( bike.toString() );
	}//main
}//end