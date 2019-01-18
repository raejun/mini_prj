package book;

public class BookDTO {
	private String title;
	private String origin_title;
	private String writer;
	private String language;
	private int publish_year;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrigin_title() {
		return origin_title;
	}
	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getPublish_year() {
		return publish_year;
	}
	public void setPublish_year(int publish_year) {
		this.publish_year = publish_year;
	}
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", origin_title=" + origin_title + ", writer=" + writer + ", language="
				+ language + ", publish_year=" + publish_year + "]";
	}
	

}


