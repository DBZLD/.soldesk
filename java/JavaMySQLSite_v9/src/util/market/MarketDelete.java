package util.market;

import java.util.Scanner;

import db.DbMarket;

public class MarketDelete {
	static void MarketDeleteMenu() {
		System.out.println("\n\n□□□□□□□   글 삭제   □□□□□□□");
		DbMarket.DbAllMarketInfo();
		System.out.print("삭제할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		MarketMain.sc = new Scanner(System.in);
		MarketMain.stInput = MarketMain.sc.nextLine();
		if (MarketMain.stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		DbMarket.DbDeleteMarket(MarketMain.stInput);
	}
}
