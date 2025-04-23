package db;

import util.board.BoardMain;

public class DbSign {
	static public void DbSignUp(String id, String pw) {
		try {
			DbBoard.stBoard.executeUpdate(String.format("insert into users(b_id, b_pw) value('%s', '%s')", id, pw));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbSignIn(String id, String pw) {
		try {
			DbBoard.result = DbBoard.stBoard
					.executeQuery(String.format("select*from users where b_id = '%s' and b_pw = '%s'", id, pw));
			if (DbBoard.result.next()) {
				System.out.println(DbBoard.result.getString("b_id") + "님 환영합니다.");
				BoardMain.MyId = id;
				BoardMain.isAdmin = DbBoard.result.getBoolean("b_admin");
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
