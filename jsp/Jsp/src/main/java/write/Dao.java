package write;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Dao {
	Connection con=null;
	Statement st = null;
	/* (1/5)���� */
	public void del(String no) {
		try {
			////���� 1
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////���� 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////���� 3
			st=con.createStatement();
			
			//�ڵ��Ͻÿ�:
			String sql = String.format("delete from %s where b_no=%s"
					,Db.TABLE_CAT_BOARD, no);
			st.executeUpdate(sql);
			
			////���� 4
			st.close();
			////���� 5
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* (2/5)���� */
	public void write(Dto d) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [����-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [����-2]			
			st=con.createStatement();	// [����-3]
			
			//���⿡ �ڵ��Ͻÿ�:
			//sql �Ǵ°� ���� �Ʒ��� �����صΰ� ���ؼ� �ۼ��Ͻð�. (�ǹ����� ȥ��. �����)
//			insert into ps_board_free (b_title,b_id,b_text) values ('�߿�','cat','aaa');
			String sql = String.format(
					"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s')"
					,Db.TABLE_CAT_BOARD, d.title,d.id,d.text);
			st.executeUpdate(sql);
			
			st.close();		// [����-4]
			con.close();	// [����-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* (3/5)�� �б� */
	public Dto read(String no) {
		Dto post = null;
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [����-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [����-2]			
			st=con.createStatement();	// [����-3]
			
			//���⿡ �ڵ��Ͻÿ�:
			//sql �Ǵ°� ���� �Ʒ��� �����صΰ� ���ؼ� �ۼ��Ͻð�. (�ǹ����� ȥ��. �����)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select * from %s where b_no=%s"
					,Db.TABLE_CAT_BOARD, no);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("b_no"),
					rs.getString("b_title"),
					rs.getString("b_id"),
					rs.getString("b_datetime"),
					rs.getString("b_hit"),
					rs.getString("b_text"),
					rs.getString("b_reply_count"),
					rs.getString("b_reply_ori")
					);
			st.close();		// [����-4]
			con.close();	// [����-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}	
	/* (4/5)�� ����Ʈ */
	public ArrayList<Dto> list() {
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [����-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [����-2]			
			st=con.createStatement();	// [����-3]
			
			//���⿡ �ڵ��Ͻÿ�:
			//sql �Ǵ°� ���� �Ʒ��� �����صΰ� ���ؼ� �ۼ��Ͻð�. (�ǹ����� ȥ��. �����)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select * from %s"
					,Db.TABLE_CAT_BOARD);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("b_no"),
						rs.getString("b_title"),
						rs.getString("b_id"),
						rs.getString("b_datetime"),
						rs.getString("b_hit"),
						rs.getString("b_text"),
						rs.getString("b_reply_count"),
						rs.getString("b_reply_ori")
						));
			}
			st.close();		// [����-4]
			con.close();	// [����-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}
	/* (5/5)���� */
	public void edit(Dto d,String no) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [����-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [����-2]			
			st=con.createStatement();	// [����-3]
			
			//���⿡ �ڵ��Ͻÿ�:
			//sql �Ǵ°� ���� �Ʒ��� �����صΰ� ���ؼ� �ۼ��Ͻð�. (�ǹ����� ȥ��. �����)
//			update ps_board_free set b_title='bb',b_text='bbbb' where b_no=4;
			String sql = String.format(
					"update %s set b_title='%s',b_text='%s' where b_no=%s"
					,Db.TABLE_CAT_BOARD, d.title,d.text,no);
			st.executeUpdate(sql);
			
			st.close();		// [����-4]
			con.close();	// [����-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}