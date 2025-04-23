package util.market;

import db.DbMarket;

public class MarketList {
	static void MarketListMenu() {
		System.out.println("\n\n□□□□□□□   글 리스트   □□□□□□□");
		DbMarket.DbListMarket();
	}
}
