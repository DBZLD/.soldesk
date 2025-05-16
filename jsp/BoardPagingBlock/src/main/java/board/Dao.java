package board;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	public ArrayList<Dto> list(String pageNum){
		Db.Connect();
		ArrayList<Dto> postList = new ArrayList<>();
		try {
			int nPageNum = Integer.getInteger(pageNum);
			String sql = String.format("select*from %s limit %s, %s", Db.TABLE_NAME, nPageNum, Db.POST_PER_PAGE);
			ResultSet result = Db.st.executeQuery(sql);
			while(result.next()) {
				Dto post = new Dto(result.getString("b_no"), result.getString("b_title"), result.getString("b_id"));
				postList.add(post);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		Db.Close();
		return postList;
	}
}
