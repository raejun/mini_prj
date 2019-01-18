package movie;

import java.sql.Date;

public class MovieDTO {
	private String movieCode;
	private String movieTitle;
	private String directName;
	private String genre;
	private String grade;
	private String acts;
	private String movieRunTime;
	private String movieCompany;
	private Date movieOpendate;
	private String movieContents;
	
	
	/*public MovieDTO(String movieCode, String movieTitle, String directName, String genre, String grade, String acts,
			String movieRunTime, String movieCompany, Date movieOpendate, String movieContents) {
		this.movieCode = movieCode;
		this.movieTitle = movieTitle;
		this.directName = directName;
		this.genre = genre;
		this.grade = grade;
		this.acts = acts;
		this.movieRunTime = movieRunTime;
		this.movieCompany = movieCompany;
		this.movieOpendate = movieOpendate;
		this.movieContents = movieContents;
	}*/

	public String getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDirectName() {
		return directName;
	}
	public void setDirectName(String directName) {
		this.directName = directName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getActs() {
		return acts;
	}
	public void setActs(String acts) {
		this.acts = acts;
	}
	public String getMovieRunTime() {
		return movieRunTime;
	}
	public void setMovieRunTime(String movieRunTime) {
		this.movieRunTime = movieRunTime;
	}
	public String getMovieCompany() {
		return movieCompany;
	}
	public void setMovieCompany(String movieCompany) {
		this.movieCompany = movieCompany;
	}
	public Date getMovieOpendate() {
		return movieOpendate;
	}
	public void setMovieOpendate(Date movieOpendate) {
		this.movieOpendate = movieOpendate;
	}
	public String getMovieContents() {
		return movieContents;
	}
	public void setMovieContents(String movieContents) {
		this.movieContents = movieContents;
	}
	@Override
	public String toString() {
		return "MovieDTO [movieCode=" + movieCode + ", movieTitle=" + movieTitle + ", directName=" + directName
				+ ", genre=" + genre + ", grade=" + grade + ", acts=" + acts + ", movieRunTime=" + movieRunTime
				+ ", movieCompany=" + movieCompany + ", movieOpendate=" + movieOpendate + ", movieContents="
				+ movieContents + "]";
	}
	
	

}//end
