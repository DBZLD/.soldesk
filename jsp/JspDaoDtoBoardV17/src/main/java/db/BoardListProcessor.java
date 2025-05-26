package db;

import java.util.ArrayList;

public class BoardListProcessor {
	private Dao dao;
	public ArrayList<Dto> posts;
	
	public void GetList() {
		this.posts = dao.list();
	}
	public BoardListProcessor(Dao dao) {
		this.dao = dao;
		GetList();
	}
}
