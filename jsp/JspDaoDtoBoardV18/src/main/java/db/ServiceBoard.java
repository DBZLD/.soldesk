package db;

public class ServiceBoard {
	Dao dao;
	
	public ServiceBoard() {
		dao = new Dao();
	}
	public void deleteBoard(String no) {
		dao.del(no);
	}
	public void writeBoard(Dto dto) {
		dao.write(dto);
	}
	public void editBoard(Dto dto, String no) {
		dao.edit(dto, no);
	}
	public boardListProcessor listBoard(String currentPage) {
		if(currentPage == null) {
			currentPage = "1";
		}
		boardListProcessor blp = new boardListProcessor(dao, currentPage);
		return blp;
	}
}
