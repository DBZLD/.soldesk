package write;

public class Db {
	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";	//mysql
//	static private String DB_JDBC_DRIVER_PACKAGE_PATH = "oracle.jdbc.OracleDriver";	//����Ŭ
	
	static private String DB_NAME = "my_cat";
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/"+DB_NAME;	//mysql
//	static private String DB_URL_ORACLE = "jdbc:oracle:thin:@127.0.0.1:1521:"+DB_NAME;	//����Ŭ
	static public String DB_URL = DB_URL_MYSQL;	//��� �ٲ�� ���� �ٲٽÿ�.
	static public String DB_ID = "root";
	static public String DB_PW = "root";
	
	/* table�� */
	////	�Խ���
	public static final String TABLE_CAT_BOARD = "cat_board";

}