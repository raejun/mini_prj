package prj1;
public class Ex16 extends Bicycle {
	protected int wheelSize;
	// ��Ŭ�� > source > Generate Constructor using fields > Generate
	public Ex16(int id, String brand, int wheelSize) {
		super(id, brand);
		this.wheelSize = wheelSize;
	}
	// ��Ŭ�� > source > Generate toSting > Generate
	@Override
	public String toString() {
		return "Ex16 [wheelSize=" + wheelSize + ", id=" + id + ", brand=" + brand + "]";
	}
	// ��Ŭ�� > source > Generate Getters and Setters > Select All > Generate
	public int getWheelSize() {
		return wheelSize;
	}
	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}
	public static void main(String[] args) {
		Ex16 bike = new Ex16(250, "��õ��", 20);
		bike.setWheelSize(25);
		System.out.println(bike);
	}//main
}//end
