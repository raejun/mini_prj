package prj1;
public abstract class TV {
	public boolean power; 
	public void onOff() {
		if(power) {
			power = false;
			System.out.println("�����ϴ�.");
		} else {
			power = true;
			System.out.println("�����ϴ�!");
		}
	}//power
	public abstract void chUp();
	public abstract void chDown();
}//end
