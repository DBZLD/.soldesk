package JavaMysqlBoard_v3;

public class Display {

	static void ShowTitle() {
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□   게시판   □□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□");
	}

	static void MainMenu() {
		System.out.print("[1.글 리스트/2.글 읽기/3.글 쓰기/4.글 삭제/5.글 수정/e.나가기]\n입력 : ");
	}

	static void BoardInfo(String title, String id, String date, String text) {
		System.out.println(String.format("%s(id : %s) %s\n%s\n", title, id, date, text));
	}

	static void BoardInfo(String title, String id, String date) {
		System.out.println(String.format("%s(id : %s) %s\n", title, id, date));
	}
}
