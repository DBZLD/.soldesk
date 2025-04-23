package util.market;

import java.util.Scanner;

import db.DbMarket;

public class MarketReset {
	static void MarketResetMenu() {
		System.out.println("\n\n□□□□□□□   글 수정   □□□□□□□");
		DbMarket.DbAllMarketInfo();
		System.out.print("수정할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
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
		DbMarket.DbResetMarket(MarketMain.stInput, stText);
	}
}
