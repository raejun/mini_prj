package Mini_BasketballDB;

public class BkPlayerInf_DTO {
	// column Name
	private String player;
	private String season;
	private int psal;
	
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getPsal() {
		return psal;
	}
	public void setPsal(int psal) {
		this.psal = psal;
	}
	@Override
	public String toString() {
		return "BkPlayerInf_DTO [player=" + player + ", season=" + season + ", psal=" + psal + "]";
	}
	
	

}
