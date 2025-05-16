package board;

public class Dto {
	public String title = null;
	public String id = null;
	public String text = null;
	public String no = null;
	public String datetime = null;
	
	public Dto(String no, String title, String id) {
		this.no = no;
		this.title = title;
		this.id = id;
	}
}
