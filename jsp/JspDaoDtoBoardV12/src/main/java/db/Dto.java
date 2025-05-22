package db;

public class Dto {
	public String no;         
	public String title;      
	public String id;         
	public String datetime;          
	public String text;       
	public Dto(String title, String id, String text) {
		this.title = title;
		this.id = id;
		this.text = text;
	}  
	public Dto(String no, String title, String id, String datetime, String text) {
		this.no = no;
		this.title = title;
		this.id = id;
		this.datetime = datetime;
		this.text = text;
	}
	public Dto(String title, String text) {
		this.title = title;
		this.text = text;
	}	
}
