package miniproject;


public class FestivalDTO {
//name, year, festival, instrumental, country, genre, explain
	private String name;
	private int year;
	private String festival;
	private int instrumental;
	private String country;
	private String genre;
	private String explain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

 
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	public String getFestival() {
		return festival;
	}


	public void setFestival(String festival) {
		this.festival = festival;
	}

	public int getInstrumental() {
		return instrumental;
	}

	public void setInstrumental(int instrumental) {
		this.instrumental = instrumental;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
 
	public String getGenre() {
		return genre;
	}
 
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	@Override
	public String toString() {
		return "FestivalDTO [name=" + name + ", year=" + year + ", festival=" + festival + ", instrumental="
				+ instrumental + ", country=" + country + ", genre=" + genre + ", explain=" + explain + "]";
	}

	
}//end

