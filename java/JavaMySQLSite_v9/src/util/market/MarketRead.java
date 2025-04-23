package util.market;

import java.util.Scanner;

import db.DbMarket;

public class MarketRead {
	static void MarketReadMenu() {
		System.out.println("\n\n□□□□□□□   글 읽기   □□□□□□□");
		DbMarket.DbAllMarketInfo();
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		MarketMain.sc = new Scanner(System.in);
		MarketMain.stInput = MarketMain.sc.nextLine();
		if (MarketMain.stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbMarket.DbReadMarket(MarketMain.stInput);
	}
}
