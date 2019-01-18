package prj1234;
public class SmartTV extends TV implements Volume {
	@Override
	public void volUp() {
		System.out.println("볼륨업");
	}
	@Override
	public void volDo() {
		System.out.println("볼륨 다운");
	}
	@Override
	public void chUp() {
		System.out.println("채널 올림");
	}
	@Override
	public void chDo() {
		System.out.println("채널 내림");
	}
	public static void main(String[] args) {
		SmartTV stv=new SmartTV();
		stv.onOff();
		stv.volUp();
		stv.volDo();
	}
}
