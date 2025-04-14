package boardV7;

public class Post {
	private String stTitle;
	private String stContent;

	public String GetTitle() {
		return stTitle;
	}

	public String GetContent() {
		return stContent;
	}

	public void SetTitle(String text) {
		this.stTitle = text;
	}

	public void SetContent(String text) {
		this.stContent = text;
	}

	Post(String title, String content) {
		this.stTitle = title;
		this.stContent = content;
	}

	Post() {

	}
}
