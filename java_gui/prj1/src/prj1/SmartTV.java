package prj1;
public class SmartTV extends TV implements Volume {
	@Override
	public void volUp() {
		System.out.println("���� �ø��ϴ�!");
	}
	@Override
	public void volDown() {
		System.out.println("���� �����ϴ�!");
	}
	@Override
	public void chUp() {
		System.out.println("ä�� �ø��ϴ�!");
	}
	@Override
	public void chDown() {
		System.out.println("ä�� �����ϴ�!");
	}
	public static void main(String[] args) {
		SmartTV stv = new SmartTV();
		stv.onOff(); // �����ϴ�.
		stv.volUp(); // ���� �ø��ϴ�!
	}//main
}//end