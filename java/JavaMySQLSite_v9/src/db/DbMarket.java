package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import display.Display;
import util.board.BoardMain;

public class DbMarket {
	static final int PER_PAGE = 5;
	static final String DB_NAME = "board";
	static final String DB_ID = "root";
	static final String DB_PW = "root";
	static Connection conMarket = null;
	static Statement stMarket = null;
	static ResultSet result = null;

	static public void DbMarketInit() {
		try {
			conMarket = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_ID, DB_PW);
			stMarket = conMarket.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbInsertMarket(String title, String id, String content) {
		try {
			stMarket.executeUpdate(
					String.format("insert into market (b_title,b_id,b_datetime,b_text) values ('%s','%s',now(),'%s')",
							title, id, content));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbDeleteMarket(String title) {
		try {
			result = stMarket.executeQuery(String.format("select*from market where b_title = '%s'", title));
			if (result.next()) {
				if (result.getString("b_id").equals(BoardMain.MyId) || BoardMain.isAdmin == true) {
					stMarket.executeUpdate(String.format("delete from market where b_title = '%s'", title));
				} else {
					System.out.println("본인의 글만 삭제할 수 있습니다.");
					return;
				}
			} else {
				System.out.println("제목과 일치하는 글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbListMarket() {
		int nowPage = 1;
		int nowIndex = 0;
		int nCountResult = 0;
		double dCount = 0.0d;
		try {
			result = stMarket.executeQuery("select count(*) as row_count from market");
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

					result = stMarket
							.executeQuery(String.format("select*from market limit %d, %d", nowIndex, PER_PAGE));
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

	static public void DbReadMarket(String title) {
		String marketNo = null;
		try {
			result = stMarket.executeQuery(String.format("select*from market where b_title = '%s'", title));

			if (result.next()) {
				Display.BoardInfo(result.getString("b_title"), result.getString("b_id"), result.getString("b_datetime"),
						result.getString("b_text"));
				marketNo = result.getString("b_no");
			} else {
				System.out.println("제목과 일치하는 글이 없습니다.");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			result = stMarket
					.executeQuery(String.format("select*from market_comments where b_market_no = '%s'", marketNo));

			while (result.next()) {
				Display.CommentsInfo(result.getString("b_id"), result.getString("b_text"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbResetMarket(String title, String text) {
		try {
			result = stMarket.executeQuery(String.format("select*from market where b_title = '%s'", title));
			if (result.next()) {
				if (result.getString("b_id").equals(BoardMain.MyId) || BoardMain.isAdmin == true) {
					stMarket.executeUpdate(
							String.format("update market set b_text = '%s' where b_title = '%s'", text, title));
				} else {
					System.out.println("본인의 글만 수정할 수 있습니다.");
					return;
				}
			} else {
				System.out.println("제목과 일치하는 글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbAllMarketInfo() {
		try {
			result = stMarket.executeQuery("select*from market");
			int i = 0;
			while (result.next()) {
				Display.BoardInfo(result.getString("b_title"), result.getString("b_id"),
						result.getString("b_datetime"));
				i++;
			}
			if (i == 0) {
				System.out.println("게시된 글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
