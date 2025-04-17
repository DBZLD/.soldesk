package q37;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	Statement st = null;
	Scanner sc;

	void run() {
		dbInit();
		Display.ShowTitle();
		Display.MainMenu();
		System.out.println("글 제목을 입력해주세요.\n입력 : ");
		sc = new Scanner(System.in);
		String stTitle = sc.nextLine();
		System.out.println("글 내용을 입력해주세요.\n입력 : ");
		sc = new Scanner(System.in);
		String stContent = sc.nextLine();
		System.out.println("Id를 입력해주세요.\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.nextLine();
		dbExecuteUpdate(String.format(
				"insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('%s','%s',now(),'%s',0)", stTitle,
				stId, stContent));

	}

	private void dbInit() {
		try {
			// (1/n) 디비 접속 정보 넣어서 접속하기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "root");
			// (2/n) Statement 객체 얻어오기.
			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열
										// 수있다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dbExecuteUpdate(String query) {
		try {
			// (3/n) Statement 객체의 executeUpdate함수에 sql문 실어서 디비에서 실행되게 하기
			int resultCount = st.executeUpdate(query); // 이거 하는 순간 디비에 sql(쿼리) 날아감. (디비에 반영됨)
			System.out.println("처리된 행 수:" + resultCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
