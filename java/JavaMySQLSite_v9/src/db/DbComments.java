package db;

public class DbComments {

	static public void DbWriteComments(String boardTitle, String id, String text) {
		try {
			int boardNo = 0;
			DbBoard.result = DbBoard.stBoard
					.executeQuery(String.format("select*from board where b_title = '%s'", boardTitle));
			while (DbBoard.result.next()) {
				boardNo = DbBoard.result.getInt("b_no");
			}
			DbBoard.stBoard.executeUpdate(String
					.format("insert into comments(b_board_no, b_id, b_text) value(%s, '%s', '%s')", boardNo, id, text));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
