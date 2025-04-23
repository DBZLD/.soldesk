package util.board;

import java.util.Scanner;

import db.DbBoard;

public class BoardReset {
	static void BoardResetMenu() {
		System.out.println("\n\n□□□□□□□   글 수정   □□□□□□□");
		DbBoard.DbAllBoardInfo();
		System.out.print("수정할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		BoardMain.sc = new Scanner(System.in);
		BoardMain.stInput = BoardMain.sc.nextLine();
		if (BoardMain.stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("내용을 입력해주세요.[e.나가기]\n입력 : ");
		BoardMain.sc = new Scanner(System.in);
		String stText = BoardMain.sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbBoard.DbResetBoard(BoardMain.stInput, stText);
	}
}
