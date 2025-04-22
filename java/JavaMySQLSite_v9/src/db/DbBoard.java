package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import display.Display;

public class DbBoard {
	static final int PER_PAGE = 3;
	static final String DB_NAME = "board";
	static final String DB_ID = "root";
	static final String DB_PW = "root";
	static Connection conBoard = null;
	static Statement stBoard = null;
	static Connection conComments = null;
	static Statement stComments = null;
	static ResultSet result = null;

	static public void DbInit() {
		try {
			conBoard = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_ID, DB_PW);
			stBoard = conBoard.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbInsertBoard(String title, String id, String content) {
		try {
			stBoard.executeUpdate(
					String.format("insert into board (b_title,b_id,b_datetime,b_text) values ('%s','%s',now(),'%s')",
							title, id, content));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbDeleteBoard(String title) {
		try {
			result = stBoard.executeQuery(String.format("select*from board where b_title = '%s'", title));
			if (result.next()) {
				stBoard.executeUpdate(String.format("delete from board where b_title = '%s'", title));
			} else {
				System.out.println("제목과 일치하는 글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbListBoard() {
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
				if (dCount <= 0) {
					System.out.println("게시된 글이 없습니다.");
				} else {
					System.out.println("\n        " + nowPage + " 페이지..." + (int) dCount + "페이지");

					result = stBoard.executeQuery(String.format("select*from board limit %d, %d", nowIndex, PER_PAGE));
					while (result.next()) {
						String b_title = result.getString("b_title");
						String b_id = result.getString("b_id");
						String b_datetime = result.getString("b_datetime");
						Display.BoardInfo(b_title, b_id, b_datetime);

					}
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

	static public void DbReadBoard(String title) {
		String boardNo = null;
		try {
			result = stBoard.executeQuery(String.format("select*from board where b_title = '%s'", title));

			if (result.next()) {
				Display.BoardInfo(result.getString("b_title"), result.getString("b_id"), result.getString("b_datetime"),
						result.getString("b_text"));
				boardNo = result.getString("b_no");
			} else {
				System.out.println("제목과 일치하는 글이 없습니다.");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			result = stBoard.executeQuery(String.format("select*from comments where b_board_no = '%s'", boardNo));

			while (result.next()) {
				Display.CommentsInfo(result.getString("b_id"), result.getString("b_text"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbResetBoard(String title, String text) {
		try {
			result = stBoard.executeQuery(String.format("select*from board where b_title = '%s'", title));
			if (result.next()) {
				stBoard.executeUpdate(
						String.format("update board set b_text = '%s' where b_title = '%s'", text, title));
			} else {
				System.out.println("제목과 일치하는 글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbAllBoardInfo() {
		try {
			result = stBoard.executeQuery("select*from board");
			if (result.next()) {
				Display.BoardInfo(result.getString("b_title"), result.getString("b_id"),
						result.getString("b_datetime"));
			} else {
				System.out.println("게시된 글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
