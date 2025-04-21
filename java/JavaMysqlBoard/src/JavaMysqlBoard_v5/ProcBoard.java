package JavaMysqlBoard_v5;

import java.util.Scanner;

public class ProcBoard {
	Scanner sc;
	String stInput;
	public static final int PER_PAGE = 3;

	void run() {
		ProcDb.DbInit();
		MainLoop();
	}

	void MainLoop() {
		while (true) {
			Display.ShowTitle();
			Display.MainMenu();
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
			case "e":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	void BoardListMenu() {
		System.out.println("글 리스트");
		ProcDb.DbListBoard();
	}

	void BoardReadMenu() {
		System.out.println("글 읽기");
		ProcDb.DbAllBoardInfo();
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			return;
		}
		ProcDb.DbReadBoard(stInput);
	}

	void BoardWriteMenu() {
		System.out.println("글 쓰기");
		System.out.print("글 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stTitle = sc.nextLine();
		if (stTitle.equals("e")) {
			return;
		}
		System.out.print("글 내용을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stText = sc.nextLine();
		if (stText.equals("e")) {
			return;
		}
		System.out.print("Id를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.nextLine();
		if (stId.equals("e")) {
			return;
		}
		ProcDb.DbInsertBoard(stTitle, stId, stText);
	}

	void BoardDeleteMenu() {
		System.out.println("글 삭제");
		ProcDb.DbAllBoardInfo();
		System.out.print("삭제할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			return;
		}
		ProcDb.DbDeleteBoard(stInput);
	}

	void BoardResetMenu() {
		System.out.println("글 수정");
		ProcDb.DbAllBoardInfo();
		System.out.print("수정할 글의 제목을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			return;
		}
		System.out.print("내용을 입력해주세요.\n입력 : ");
		sc = new Scanner(System.in);
		String stText = sc.nextLine();
		ProcDb.DbResetBoard(stInput, stText);
	}
}
