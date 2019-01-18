package prj1;
public abstract class TV {
	public boolean power; 
	public void onOff() {
		if(power) {
			power = false;
			System.out.println("꺼집니다.");
		} else {
			power = true;
			System.out.println("켜집니다!");
		}
	}//power
	public abstract void chUp();
	public abstract void chDown();
}//end
