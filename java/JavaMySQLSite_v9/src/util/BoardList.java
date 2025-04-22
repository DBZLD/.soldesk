package util;

import db.DbBoard;

public class BoardList {
	static void BoardListMenu() {
		System.out.println("\n\n□□□□□□□   글 리스트   □□□□□□□");
		DbBoard.DbListBoard();
	}
}
