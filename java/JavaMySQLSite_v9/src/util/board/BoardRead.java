package util.board;

import java.util.Scanner;

import db.DbBoard;

public class BoardRead {
	static void BoardReadMenu() {
		System.out.println("\n\n□□□□□□□   글 읽기   □□□□□□□");
		DbBoard.DbAllBoardInfo();
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		BoardMain.sc = new Scanner(System.in);
		BoardMain.stInput = BoardMain.sc.nextLine();
		if (BoardMain.stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbBoard.DbReadBoard(BoardMain.stInput);
	}
}
