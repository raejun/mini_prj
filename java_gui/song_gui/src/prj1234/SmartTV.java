package prj1234;
public class SmartTV extends TV implements Volume {
	@Override
	public void volUp() {
		System.out.println("������");
	}
	@Override
	public void volDo() {
		System.out.println("���� �ٿ�");
	}
	@Override
	public void chUp() {
		System.out.println("ä�� �ø�");
	}
	@Override
	public void chDo() {
		System.out.println("ä�� ����");
	}
	public static void main(String[] args) {
		SmartTV stv=new SmartTV();
		stv.onOff();
		stv.volUp();
		stv.volDo();
	}
}
