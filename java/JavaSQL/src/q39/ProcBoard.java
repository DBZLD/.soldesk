package q39;

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
		DbInit();
		Display.ShowTitle();
		MainLoop();
	}

	void MainLoop() {
		while (true) {
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
				DbInsertPost(stTitle, stId, stContent);
				break;
			case "4":
				System.out.println("글 삭제");
				System.out.print("삭제할 글의 제목을 입력해주세요.\n입력 : ");
				sc = new Scanner(System.in);
				stInput = sc.nextLine();
				DbDeletePost(stInput);
				break;
			case "5":
				System.out.println("글 수정");
				break;
			case "e":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	private void DbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "root");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DbInsertPost(String title, String id, String content) {
		try {
			st.executeUpdate(String.format(
					"insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('%s','%s',now(),'%s',0)", title,
					id, content));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DbDeletePost(String title) {
		try {
			st.executeUpdate(String.format("delete from board where b_title = '%s'", title));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
