package JavaMysqlSite_v3;

import java.util.Scanner;

public class ProcBoard {
	Scanner sc;
	String stInput;
	static final int PER_PAGE = 3;

	void run() {
		ProcDb.DbInit();
		MainLoop();
	}

	void MainLoop() {
		while (true) {
			Display.ShowSiteTitle();
			Display.MainMenu();
			sc = new Scanner(System.in);
			stInput = sc.nextLine();
			switch (stInput) {
			case "1":
				SignUp();
				break;
			case "2":
				SignIn();
				break;
			case "3":
				BoardLoop();
				break;
			case "e":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	void SignUp() {
		System.out.println("□□□□□□□   회원가입   □□□□□□□");
		System.out.print("아이디를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			System.out.println("메인메뉴로 나가기");
			return;
		}
		System.out.print("비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			System.out.println("메인메뉴로 나가기");
			return;
		}
		ProcDb.DbSignUp(stId, stPw);
	}

	void SignIn() {
		System.out.println("□□□□□□□   로그인   □□□□□□□");
		System.out.print("아이디를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			System.out.println("메인메뉴로 나가기");
			return;
		}
		System.out.print("비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			System.out.println("메인메뉴로 나가기");
			return;
		}
		ProcDb.DbSignIn(stId, stPw);
	}

	void BoardLoop() {
		while (true) {
			Display.ShowBoardTitle();
			Display.BoardMenu();
			sc = new Scanner(System.in);
			stInput = sc.nextLine();
			switch (stInput) {
			case "1":
				BoardListMenu();
				break;
			case "2":
				BoardReadMenu();
				break;
			case "3":
				BoardWriteMenu();
				break;
			case "4":
				BoardDeleteMenu();
				break;
			case "5":
				BoardResetMenu();
				break;
			case "6":
				BoardCommentsMenu();
				break;
			case "e":
				System.out.println("메인 메뉴로 나가기");
				return;
			}
		}
	}

	void BoardListMenu() {
		System.out.println("□□□□□□□   글 리스트   □□□□□□□");
		ProcDb.DbListBoard();
	}

	void BoardReadMenu() {
		System.out.println("□□□□□□□   글 읽기   □□□□□□□");
		ProcDb.DbAllBoardInfo();
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		ProcDb.DbReadBoard(stInput);
	}

	void BoardWriteMenu() {
		System.out.println("□□□□□□□   글 쓰기   □□□□□□□");
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stTitle = sc.nextLine();
		if (stTitle.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("글 내용을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stText = sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("Id를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.nextLine();
		if (stId.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		ProcDb.DbInsertBoard(stTitle, stId, stText);
	}

	void BoardDeleteMenu() {
		System.out.println("□□□□□□□   글 삭제   □□□□□□□");
		ProcDb.DbAllBoardInfo();
		System.out.print("삭제할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		ProcDb.DbDeleteBoard(stInput);
	}

	void BoardResetMenu() {
		System.out.println("□□□□□□□   글 수정   □□□□□□□");
		ProcDb.DbAllBoardInfo();
		System.out.print("수정할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("내용을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stText = sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		ProcDb.DbResetBoard(stInput, stText);
	}

	void BoardCommentsMenu() {
		System.out.println("□□□□□□□   댓글 작성   □□□□□□□");
		ProcDb.DbAllBoardInfo();
		System.out.print("댓글을 작성할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("id를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.nextLine();
		if (stId.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		System.out.print("내용을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stText = sc.nextLine();
		if (stText.equals("e")) {
			System.out.println("게시판 메뉴로 나가기");
			return;
		}
		ProcDb.DbWriteComments(stInput, stId, stText);
	}
}