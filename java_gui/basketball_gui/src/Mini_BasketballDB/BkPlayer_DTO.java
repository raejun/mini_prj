package Mini_BasketballDB;

public class BkPlayer_DTO {
	// column Name
	private String player;
	private String season;
	private double p3p;
	private double p2p;
	private double ftp;
	private double trb;
	private double ast;
	private double stl;
	private double blk;
	private double tov;
	private double pts;

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
	public double getP3p() {
		return p3p;
	}
	public void setP3p(double p3p) {
		this.p3p = p3p;
	}
	public double getP2p() {
		return p2p;
	}
	public void setP2p(double p2p) {
		this.p2p = p2p;
	}
	public double getFtp() {
		return ftp;
	}
	public void setFtp(double ftp) {
		this.ftp = ftp;
	}
	public double getTrb() {
		return trb;
	}
	public void setTrb(double trb) {
		this.trb = trb;
	}
	public double getAst() {
		return ast;
	}
	public void setAst(double ast) {
		this.ast = ast;
	}
	public double getStl() {
		return stl;
	}
	public void setStl(double stl) {
		this.stl = stl;
	}
	public double getBlk() {
		return blk;
	}
	public void setBlk(double blk) {
		this.blk = blk;
	}
	public double getTov() {
		return tov;
	}
	public void setTov(double tov) {
		this.tov = tov;
	}
	public double getPts() {
		return pts;
	}
	public void setPts(double pts) {
		this.pts = pts;
	}
	@Override
	public String toString() {
		return "BK_DTO [player=" + player + ", season=" + season + ", p3p=" + p3p + ", p2p=" + p2p + ", ftp=" + ftp + ", trb=" + trb
				+ ", ast=" + ast + ", stl=" + stl + ", blk=" + blk + ", tov=" + tov + ", pts=" + pts + "]";
	}
	
	
}//end
