package display;

import util.board.BoardMain;
import util.market.MarketMain;

public class Display {
	static public void ShowSiteTitle() {
		System.out.println("\n\n\n");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□   사이트   □□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
	}

	static public void ShowBoardTitle() {
		System.out.println("\n\n\n");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□   게시판   □□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
	}

	static public void ShowMarketTitle() {
		System.out.println("\n\n\n");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□   " + MarketMain.marketName + "   □□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
	}

	static public void BoardMenu() {
		System.out.print("[1.글 리스트/2.글 읽기/3.글 쓰기/4.글 삭제/5.글 수정/6.댓글 작성/e.나가기]\n입력 : ");
	}

	static public void MarketMenu() {
		System.out.print("[1.글 리스트/2.글 읽기/3.글 쓰기/4.글 삭제/5.글 수정/6.댓글 작성/e.나가기]\n입력 : ");
	}

	static public void MainMenu() {
		if (BoardMain.MyId != null) {
			if (BoardMain.isAdmin == true) {
				System.out.println(String.format("[1.회원가입/2.게시판/3.%s/4.%s 이름 바꾸기/e.나가기]\n입력 : ", MarketMain.marketName,
						MarketMain.marketName));
			} else {
				System.out.print("[1.회원가입/2.게시판/3." + MarketMain.marketName + "/e.나가기]\n입력 : ");
			}
		} else {
			System.out.print("[1.회원가입/2.로그인/e.나가기]\n입력 : ");
		}
	}

	static public void BoardInfo(String title, String id, String date, String text) {
		System.out.println(String.format("%s(id : %s) %s\n%s\n댓글---------------------------", title, id, date, text));
	}

	static public void BoardInfo(String title, String id, String date) {
		System.out.println(String.format("%s(id : %s) %s", title, id, date));
	}

	static public void CommentsInfo(String id, String text) {
		System.out.println(String.format("%s || %s", id, text));
	}
}
