package util.market;

import java.util.Scanner;

import db.DbMarket;
import util.board.BoardMain;

public class MarketWrite {
	static void MarketWriteMenu() {
		System.out.println("\n\n□□□□□□□   글 쓰기   □□□□□□□");
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		MarketMain.sc = new Scanner(System.in);
		String stTitle = MarketMain.sc.nextLine();
		if (stTitle.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("글 내용을 입력해주세요.[e.나가기]\n입력 : ");
		MarketMain.sc = new Scanner(System.in);
		String stText = MarketMain.sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbMarket.DbInsertMarket(stTitle, BoardMain.MyId, stText);
	}
}
