package db;

public class ServiceBoard {
	Dao dao;
	
	public ServiceBoard() {
		dao = new Dao();
	}
	public void DeleteBoard(String no) {
		dao.del(no);
	}
}
