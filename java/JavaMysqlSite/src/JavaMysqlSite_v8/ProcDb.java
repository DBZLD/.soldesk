package JavaMysqlSite_v8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcDb {
	static final int PER_PAGE = 3;
	static final String DB_NAME = "board";
	static final String DB_ID = "root";
	static final String DB_PW = "root";
	static Connection conBoard = null;
	static Statement stBoard = null;
	static Connection conComments = null;
	static Statement stComments = null;
	static ResultSet result = null;

	static void DbInit() {
		try {
			conBoard = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_ID, DB_PW);
			stBoard = conBoard.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DbInsertBoard(String title, String id, String content) {
		try {
			stBoard.executeUpdate(
					String.format("insert into board (b_title,b_id,b_datetime,b_text) values ('%s','%s',now(),'%s')",
							title, id, content));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DbDeleteBoard(String title) {
		try {
			stBoard.executeUpdate(String.format("delete from board where b_title = '%s'", title));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DbListBoard() {
		int nowPage = 1;
		int nowIndex = 0;
		int nCountResult = 0;
		double dCount = 0.0d;
		try {
			result = stBoard.executeQuery("select count(*) as row_count from board");
			if (result.next()) {
				nCountResult = result.getInt("row_count");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("글 리스트[숫자 입력.n페이지로 이동/e.나가기]");
				dCount = Math.ceil((float) nCountResult / (float) PER_PAGE);
				System.out.println("\n        " + nowPage + " 페이지..." + (int) dCount + "페이지");

				result = stBoard.executeQuery(String.format("select*from board limit %d, %d", nowIndex, PER_PAGE));
				while (result.next()) {
					String b_title = result.getString("b_title");
					String b_id = result.getString("b_id");
					String b_datetime = result.getString("b_datetime");

					Display.BoardInfo(b_title, b_id, b_datetime);
				}
				System.out.print("입력 : ");
				Scanner sc = new Scanner(System.in);
				String stInput = sc.next();
				if (stInput.equals("e")) {
					return;
				}
				if (PER_PAGE * (Integer.parseInt(stInput) - 1) > nCountResult) {
					System.out.println("페이지 범위를 넘어선 수입니다.");
				} else {
					nowPage = Integer.parseInt(stInput);
					nowIndex = (nowPage - 1) * PER_PAGE;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void DbReadBoard(String title) {
		int boardNo;
		try {
			result = stBoard.executeQuery(String.format("select*from board where b_title = '%s'", title));

			while (result.next()) {
				Display.BoardInfo(result.getString("b_title"), result.getString("b_id"), result.getString("b_datetime"),
						result.getString("b_text"));
				boardNo = Integer.parseInt(result.getString("b_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			result = stBoard.executeQuery(String.format("select*from comments where b_board_no = '%s'", title));

			while (result.next()) {
				Display.CommentsInfo(result.getString("b_id"), result.getString("b_text"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DbResetBoard(String title, String text) {
		try {
			stBoard.executeUpdate(String.format("update board set b_text = '%s' where b_title = '%s'", text, title));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void DbWriteComments(String boardTitle, String id, String text) {
		try {
			int boardNo = 0;
			result = stBoard.executeQuery(String.format("select*from board where b_title = '%s'", boardTitle));
			while (result.next()) {
				boardNo = result.getInt("b_no");
			}
			stBoard.executeUpdate(String.format("insert into comments(b_board_no, b_id, b_text) value(%s, '%s', '%s')",
					boardNo, id, text));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void DbSignUp(String id, String pw) {
		try {
			stBoard.executeUpdate(String.format("insert into users(b_id, b_pw) value('%s', '%s')", id, pw));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DbSignIn(String id, String pw) {
		try {
			result = stBoard.executeQuery(String.format("select*from users where b_id = '%s' and b_pw = '%s'", id, pw));
			if (result.next()) {
				System.out.println(result.getString("b_id") + "님 환영합니다.");
				ProcBoard.MyId = id;
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DbAllBoardInfo() {
		try {
			result = stBoard.executeQuery("select*from board");
			while (result.next()) {
				Display.BoardInfo(result.getString("b_title"), result.getString("b_id"),
						result.getString("b_datetime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
