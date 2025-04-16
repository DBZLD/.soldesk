package boardV9;

public class Post {
	private String stTitle;
	private String stWriter;
	private String stContent;
	private String stDate;

	public String GetTitle() {
		return stTitle;
	}

	public String GetWriter() {
		return stWriter;
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

	public void SetWriter(String text) {
		this.stWriter = text;
	}

	public void SetContent(String text) {
		this.stContent = text;
	}

	public void SetDate(String text) {
		this.stDate = text;
	}

	public void ReadPost() {
		System.out.println(String.format("\n%s(%s) [%s]\n%s\n", GetTitle(), GetWriter(), GetDate(), GetContent()));
	}

	Post(String title, String writer, String content, String date) {
		this.stTitle = title;
		this.stWriter = writer;
		this.stContent = content;
		this.stDate = date;
	}

	Post() {

	}
}
