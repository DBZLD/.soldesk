package util;

import java.util.Scanner;

import db.DbBoard;
import db.DbComments;

public class BoardWriteComments {
	static void BoardCommentsMenu() {
		System.out.println("\n\n□□□□□□□   댓글 작성   □□□□□□□");
		DbBoard.DbAllBoardInfo();
		System.out.print("댓글을 작성할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
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
		DbComments.DbWriteComments(BoardMain.stInput, BoardMain.MyId, stText);
	}
}
