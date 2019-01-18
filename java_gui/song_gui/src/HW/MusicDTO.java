package HW;

import java.util.Date;

public class MusicDTO {
	private String Artist;
	private String Title;
	private int Length;
	private String Genre;
	private int Ranking;
	private String Release;
	private String Composer;
	//getter setter
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getLength() {
		return Length;
	}
	public void setLength(int length) {
		Length = length;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public int getRanking() {
		return Ranking;
	}
	public void setRanking(int ranking) {
		Ranking = ranking;
	}
	public String getRelease() {
		return Release;
	}
	public void setRelease(String release) {
		Release = release;
	}
	public String getComposer() {
		return Composer;
	}
	public void setComposer(String composer) {
		Composer = composer;
	}
	@Override
	public String toString() {
		return "MusicDTO [Artist=" + Artist + ", Title=" + Title + ", Length=" + Length + ", Genre=" + Genre
				+ ", Ranking=" + Ranking + ", Release=" + Release + ", Composer=" + Composer + "]";
	}

}
