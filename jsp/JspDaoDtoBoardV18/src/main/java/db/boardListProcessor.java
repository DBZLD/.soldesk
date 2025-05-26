package db;

import java.util.ArrayList;

public class boardListProcessor {
	public ArrayList<Dto> posts;
	public int totalPage = 0;
	public int startIndex = 0;
	
	public boardListProcessor(Dao dao, String currentPage) {
		this.startIndex = getStartIndex(Integer.parseInt(currentPage));
		this.totalPage = dao.count();
		this.posts = dao.list(Integer.parseInt(currentPage), startIndex);
	}
	public String getPageHTML() {
		String html = "";
		for(int i = 1; i < totalPage; i++) {
			html += String.format("<a href='/board/list?currentPage=%d'>%d</a>&nbsp;&nbsp;", i, i);
		}
		return html;
	}
	public int getStartIndex(int currentPage) {
		int startIndex = 0;
		if((currentPage - 1) % Board.POST_PER_PAGE == 0){
			startIndex = (currentPage - 1) / Board.POST_PER_PAGE;			
	//todo	
		return startIndex;
	}
}
