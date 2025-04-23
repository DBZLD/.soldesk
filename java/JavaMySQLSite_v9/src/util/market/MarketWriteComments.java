package util.market;

import java.util.Scanner;

import db.DbMarket;
import db.DbMarketComments;
import util.board.BoardMain;

public class MarketWriteComments {
	static void BoardCommentsMenu() {
		System.out.println("\n\n□□□□□□□   댓글 작성   □□□□□□□");
		DbMarket.DbAllMarketInfo();
		System.out.print("댓글을 작성할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		MarketMain.sc = new Scanner(System.in);
		MarketMain.stInput = MarketMain.sc.nextLine();
		if (MarketMain.stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("내용을 입력해주세요.[e.나가기]\n입력 : ");
		MarketMain.sc = new Scanner(System.in);
		String stText = MarketMain.sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbMarketComments.DbWriteMarketComments(MarketMain.stInput, BoardMain.MyId, stText);
	}
}
