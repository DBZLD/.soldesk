package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Db {
	public static final String DB_NAME = "board_paging";
	public static final String TABLE_NAME = "board";
	public static final String DB_ID = "root";
	public static final String DB_PW = "root";

	public static final String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	
	public static final int POST_PER_PAGE = 5;
	public static final int PAGE_PER_BLOCK = 5;
	
	public static Connection con;
	public static Statement st;
	
	public static void Connect() {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			con = DriverManager.getConnection(DB_URL_MYSQL, DB_ID, DB_PW);			
			st = con.createStatement();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static void Close() {
		try {
			con.close();
			st.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
