package db;

public class ServiceBoard {
	Dao dao;
	
	public ServiceBoard() {
		dao = new Dao();
	}
	public void DeleteBoard(String no) {
		dao.del(no);
	}
	public void WriteBoard(Dto dto) {
		dao.write(dto);
	}
	public void EditBoard(Dto dto, String no) {
		dao.edit(dto, no);
	}
}
