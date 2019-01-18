package prj1;
public class SmartTV extends TV implements Volume {
	@Override
	public void volUp() {
		System.out.println("볼륨 올립니다!");
	}
	@Override
	public void volDown() {
		System.out.println("볼륨 내립니다!");
	}
	@Override
	public void chUp() {
		System.out.println("채널 올립니다!");
	}
	@Override
	public void chDown() {
		System.out.println("채널 내립니다!");
	}
	public static void main(String[] args) {
		SmartTV stv = new SmartTV();
		stv.onOff(); // 켜집니다.
		stv.volUp(); // 볼륨 올립니다!
	}//main
}//end