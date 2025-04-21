package JavaMysqlSite_v5;

public class Display {

	static void ShowSiteTitle() {
		System.out.println("\n\n\n");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□   사이트   □□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
	}

	static void ShowBoardTitle() {
		System.out.println("\n\n\n");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□   게시판   □□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
	}

	static void BoardMenu() {
		System.out.print("[1.글 리스트/2.글 읽기/3.글 쓰기/4.글 삭제/5.글 수정/6.댓글 작성/e.나가기]\n입력 : ");
	}

	static void MainMenu() {
		if (ProcBoard.MyId != null) {
			System.out.print("[1.회원가입/2.게시판/e.나가기]\n입력 : ");
		} else {
			System.out.print("[1.회원가입/2.로그인/e.나가기]\n입력 : ");
		}
	}

	static void BoardInfo(String title, String id, String date, String text) {
		System.out.println(String.format("%s(id : %s) %s\n%s\n댓글---------------------------", title, id, date, text));
	}

	static void BoardInfo(String title, String id, String date) {
		System.out.println(String.format("%s(id : %s) %s", title, id, date));
	}

	static void CommentsInfo(String id, String text) {
		System.out.println(String.format("%s || %s", id, text));
	}
}
