package boardV9;

public class Post {
	private String stTitle;
	private String stContent;
	private String stDate;

	public String GetTitle() {
		return stTitle;
	}

	public String GetContent() {
		return stContent;
	}

	public String GetDate() {
		return stDate;
	}

	public void SetTitle(String text) {
		this.stTitle = text;
	}

	public void SetContent(String text) {
		this.stContent = text;
	}

	public void SetDate(String text) {
		this.stDate = text;
	}

	Post(String title, String content, String date) {
		this.stTitle = title;
		this.stContent = content;
		this.stDate = date;
	}

	Post() {

	}
}
