package util.board;

import java.util.Scanner;

import db.DbBoard;
import db.DbSign;
import display.Display;
import util.market.MarketMain;

public class BoardMain {
	static Scanner sc;
	static String stInput;
	public static String MyId = null;
	public static boolean isAdmin = false;

	public void run() {
		DbBoard.DbBoardInit();
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
				if (MyId != null) {
					SignOut();
				} else {
					SignUp();
				}
				break;
			case "2":
				if (MyId != null) {
					BoardLoop();
				} else {
					SignIn();
				}
				break;
			case "3":
				if (MyId != null) {
					MarketMain.MarketLoop();
				}
				break;
			case "4":
				if (isAdmin == true) {
					MarketMain.ChangeMatcketName();
				}
				break;
			case "e":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	void SignUp() {
		System.out.println("\n\n□□□□□□□   회원가입   □□□□□□□");
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
		DbSign.DbSignUp(stId, stPw);
		System.out.println("회원가입 완료");
	}

	void SignIn() {
		System.out.println("\n\n□□□□□□□   로그인   □□□□□□□");
		System.out.print("아이디를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			System.out.println("메인메뉴로 나가기");
			return;
		}
		System.out.print("\n\n비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			System.out.println("메인메뉴로 나가기");
			return;
		}
		DbSign.DbSignIn(stId, stPw);
	}

	void SignOut() {
		System.out.println("\n\n□□□□□□□   로그인   □□□□□□□");
		System.out.println("로그아웃 하시겠습니까?[y/n]");
		sc = new Scanner(System.in);
		stInput = sc.next();
		if (stInput.equals("y")) {
			MyId = null;
			isAdmin = false;
		} else {
			System.out.println("메인메뉴로 나가기");
			return;
		}
	}

	void BoardLoop() {
		while (true) {
			Display.ShowBoardTitle();
			Display.BoardMenu();
			sc = new Scanner(System.in);
			stInput = sc.nextLine();
			switch (stInput) {
			case "1":
				BoardList.BoardListMenu();
				break;
			case "2":
				BoardRead.BoardReadMenu();
				break;
			case "3":
				BoardWrite.BoardWriteMenu();
				break;
			case "4":
				BoardDelete.BoardDeleteMenu();
				break;
			case "5":
				BoardReset.BoardResetMenu();
				break;
			case "6":
				BoardWriteComments.BoardCommentsMenu();
				break;
			case "e":
				System.out.println("메인 메뉴로 나가기");
				return;
			}
		}
	}
}
