package prj1234;

public abstract class TV {
	public boolean power;
	public void onOff() {
		if(power) {
			power = false;
			System.out.println("����");
		}else {
			power = true;
			System.out.println("����");
		}
		
	}//power
	public abstract void chUp();
	public abstract void chDo();

}
