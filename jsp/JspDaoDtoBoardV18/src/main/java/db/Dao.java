package db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao extends Da{
	public void del(String no) {
		super.connect();	
		String sql = String.format("delete from %s where b_no=%s"
				,Db.TABLE_NAME, no);
		super.update(sql);
		super.close();	
	}
	public void write(Dto d) {
		super.connect();	
		String sql = String.format(
				"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s')"
				,Db.TABLE_NAME, d.title,d.id,d.text);
		super.update(sql);
		super.close();	
	}
	public Dto read(String no) {
		super.connect();	
		Dto post = null;
		try {
			String sql = String.format(
					"select * from %s where b_no=%s"
					,Db.TABLE_NAME, no);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("b_no"),
					rs.getString("b_title"),
					rs.getString("b_id"),
					rs.getString("b_datetime"),
					rs.getString("b_text")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	
		return post;
	}	
	public ArrayList<Dto> list(int currentPage, int startIndex) {
		super.connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format("select*from %s limit %d, %d", Db.TABLE_NAME, startIndex, Board.POST_PER_PAGE);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("b_no"),
						rs.getString("b_title"),
						rs.getString("b_id"),
						rs.getString("b_datetime"),
						rs.getString("b_text")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	
		return posts;
	}
	public void edit(Dto d,String no) {
		super.connect();	
		String sql = String.format(
				"update %s set b_title='%s',b_text='%s' where b_no=%s"
				,Db.TABLE_NAME, d.title,d.text,no);
		super.update(sql);
		super.close();	
	}
	public int count() {
		int totalPage = 0;
		super.connect();	
		String sql = String.format(
				"select count(*) from %s"
				,Db.TABLE_NAME);
		try {
			ResultSet result = st.executeQuery(sql);
			result.next();
			if(result.getInt("count(*)")%Board.POST_PER_PAGE == 0) {
				totalPage = result.getInt("count(*)")/Board.POST_PER_PAGE;				
			}
			else {
				totalPage = result.getInt("count(*)")/Board.POST_PER_PAGE + 1;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return totalPage;
	}
}