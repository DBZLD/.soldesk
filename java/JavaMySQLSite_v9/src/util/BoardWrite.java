package util;

import java.util.Scanner;

import db.DbBoard;

public class BoardWrite {
	static void BoardWriteMenu() {
		System.out.println("\n\n□□□□□□□   글 쓰기   □□□□□□□");
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		BoardMain.sc = new Scanner(System.in);
		String stTitle = BoardMain.sc.nextLine();
		if (stTitle.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("글 내용을 입력해주세요.[e.나가기]\n입력 : ");
		BoardMain.sc = new Scanner(System.in);
		String stText = BoardMain.sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbBoard.DbInsertBoard(stTitle, BoardMain.MyId, stText);
	}
}
