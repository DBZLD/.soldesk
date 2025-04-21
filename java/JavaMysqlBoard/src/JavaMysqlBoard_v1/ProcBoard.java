package JavaMysqlBoard_v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection conBoard = null;
	Statement stBoard = null;
	ResultSet result = null;
	Scanner sc;
	String stInput;
	static final int PER_PAGE = 3;

	void run() {
		DbInitBoard();
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
				DbListPost();
				break;
			case "2":
				System.out.println("글 읽기");
				System.out.print("글 제목을 입력해주세요.\n입력 : ");
				sc = new Scanner(System.in);
				stInput = sc.nextLine();
				DbReadPost(stInput);
				break;
			case "3":
				System.out.println("글 쓰기");
				System.out.print("글 제목을 입력해주세요.\n입력 : ");
				sc = new Scanner(System.in);
				String stTitle = sc.nextLine();
				System.out.print("글 내용을 입력해주세요.\n입력 : ");
				sc = new Scanner(System.in);
				String stContent = sc.nextLine();
				System.out.print("Id를 입력해주세요.\n입력 : ");
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
				System.out.print("수정할 글의 제목을 입력해주세요.\n입력 : ");
				sc = new Scanner(System.in);
				stInput = sc.nextLine();
				System.out.print("내용을 입력해주세요.\n입력 : ");
				sc = new Scanner(System.in);
				String stText = sc.nextLine();
				DbResetPost(stInput, stText);
				break;
			case "e":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	private void DbInitBoard() {
		try {
			conBoard = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "root");
			stBoard = conBoard.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DbInsertPost(String title, String id, String content) {
		try {
			stBoard.executeUpdate(
					String.format("insert into board (b_title,b_id,b_datetime,b_text) values ('%s','%s',now(),'%s')",
							title, id, content));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DbDeletePost(String title) {
		try {
			stBoard.executeUpdate(String.format("delete from board where b_title = '%s'", title));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DbListPost() {
		int nowPage = 1;
		int nowIndex = 0;
		int nCountResult = 0;
		double dCount = 0.0d;
		try {
			ResultSet countResult = stBoard.executeQuery("select count(*) as row_count from board");
			if (countResult.next()) {
				nCountResult = countResult.getInt("row_count");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("글 리스트[숫자 입력.n페이지로 이동/e.나가기]");

				System.out.println("\n        " + nowPage + " 페이지...");

				result = stBoard.executeQuery(String.format("select*from board limit %d, %d", nowIndex, PER_PAGE));
				while (result.next()) {
					String b_title = result.getString("b_title");
					String b_id = result.getString("b_id");
					String b_datetime = result.getString("b_datetime");

					Display.PostInfo(b_title, b_id, b_datetime);
				}
				System.out.print("입력 : ");
				sc = new Scanner(System.in);
				stInput = sc.next();
				if (stInput.equals("e")) {
					return;
				}
				nowPage = Integer.parseInt(stInput);
				nowIndex = (nowPage - 1) * PER_PAGE;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void DbReadPost(String title) {
		try {
			result = stBoard.executeQuery(String.format("select*from board where b_title = '%s'", title));

			while (result.next()) {
				Display.PostInfo(result.getString("b_title"), result.getString("b_id"), result.getString("b_datetime"),
						result.getString("b_text"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DbResetPost(String title, String text) {
		try {
			stBoard.executeQuery(String.format("update board set b_text = '%s'where b_title = '%s'", text, title));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
