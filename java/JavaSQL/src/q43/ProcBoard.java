package q43;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	Scanner sc;
	String stInput;
	static final int PER_PAGE = 3;

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

	private void DbListPost() {
		int nowPage = 0;
		int nowIndex = 0;
		boolean isPrint;
		while (true) {
			try {
				System.out.println("글 리스트[a.이전 페이지/d.다음 페이지/e.나가기]");
				System.out.println("            " + (nowPage + 1) + " 페이지");
				result = st.executeQuery(String.format("select*from board limit %d, %d", nowIndex, PER_PAGE));
				isPrint = false;
				while (result.next()) {
					String b_title = result.getString("b_title");
					String b_id = result.getString("b_id");
					String b_datetime = result.getString("b_datetime");

					Display.PostInfo(b_title, b_id, b_datetime);
					isPrint = true;

				}
				System.out.print("입력 : ");
				sc = new Scanner(System.in);
				stInput = sc.nextLine();
				switch (stInput) {
				case "a":
					if (nowPage != 0) {
						nowPage--;
						nowIndex -= PER_PAGE;
					}
					break;
				case "d":
					if (isPrint) {
						nowPage++;
						nowIndex += PER_PAGE;
					}
					break;
				case "e":
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void DbReadPost(String title) {
		try {
			result = st.executeQuery(String.format("select*from board where b_title = '%s'", title));

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
			st.executeQuery(String.format("update board set b_text = '%s'where b_title = '%s'", text, title));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
