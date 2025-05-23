package db;

import java.util.ArrayList;

public class BoardListProcessor {
	Dao dao;
	public ArrayList<Dto> posts;
	
	public void GetList() {
		posts = dao.list();
	}
	public BoardListProcessor() {
		GetList();
	}
}
