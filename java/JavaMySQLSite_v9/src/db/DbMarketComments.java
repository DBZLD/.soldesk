package db;

public class DbMarketComments {

	static public void DbWriteMarketComments(String marketTitle, String id, String text) {
		try {
			int marketNo = 0;
			DbMarket.result = DbMarket.stMarket
					.executeQuery(String.format("select*from market where b_title = '%s'", marketTitle));
			while (DbMarket.result.next()) {
				marketNo = DbMarket.result.getInt("b_no");
			}
			DbBoard.stBoard.executeUpdate(String.format(
					"insert into marekt_comments(b_board_no, b_id, b_text) value(%s, '%s', '%s')", marketNo, id, text));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
