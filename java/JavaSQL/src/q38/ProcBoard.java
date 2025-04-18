package q38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	Statement st = null;
	Scanner sc;
	String stInput;

	void run() {
		dbInit();
		Display.ShowTitle();
		MainLoop();
	}

	void MainLoop() {
		Display.MainMenu();
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		switch (stInput) {
		case "1":
			System.out.println("글 리스트");
			break;
		case "2":
			System.out.println("글 읽기");
			break;
		case "3":
			System.out.println("글 쓰기");
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
			break;
		case "4":
			System.out.println("글 삭제");
			break;
		case "5":
			System.out.println("글 수정");
			break;
		case "e":
			System.out.println("프로그램 종료");
			return;
		}
	}

	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "root");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dbExecuteUpdate(String query) {
		try {
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
