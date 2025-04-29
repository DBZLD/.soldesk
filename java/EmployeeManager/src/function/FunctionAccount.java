package function;

import java.util.Scanner;

import db.DbAccount;
import display.Display;

public class FunctionAccount {
	static FunctionMain fMain = FunctionMain.getInstance();
	static Scanner sc;

	public static void SignIn() {
		Display.Line();
		System.out.print("아이디를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			Display.Line();
			System.out.println("취소");
			return;
		}
		Display.Line();
		System.out.print("비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			Display.Line();
			System.out.println("취소");
			return;
		}
		if (DbAccount.DbSignIn(stId, stPw)) {
			Display.Line();
			System.out.println(String.format("%s %s님 환영합니다.", stId, DbAccount.GetPosition()));
			fMain.SetMyId(DbAccount.GetId());
			fMain.SetnPosition(DbAccount.GetPosition());
		} else {
			Display.Line();
			System.out.println("비밀번호 또는 아이디가 일치하지 않습니다.");
		}
	}

	public static void SignUp() {
		Display.Line();
		System.out.print("아이디를 입력해주세요(이름).[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			Display.Line();
			System.out.println("취소");
			return;
		}
		Display.Line();
		System.out.print("비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			Display.Line();
			System.out.println("취소");
			return;
		}
		if (DbAccount.DbSignUp(stId, stPw)) {
			Display.Line();
			System.out.println("회원가입 성공");
		} else {
			Display.Line();
			System.out.println("알맞지 않은 아이디입니다.");
		}
	}

	public static void SignOut() {
		Display.Line();
		System.out.print("로그아웃 하시겠습니까?[y,n]\n입력 : ");
		sc = new Scanner(System.in);
		String stInput = sc.next();
		if (stInput.equals("y")) {
			Display.Line();
			System.out.println("로그아웃 완료");
			fMain.SetMyId(null);
			fMain.SetnPosition("");
			return;
		} else if (stInput.equals("n")) {
			Display.Line();
			System.out.println("로그아웃 취소");
			return;
		} else {
			Display.Line();
			System.out.println("잘못된 입력입니다.");
			return;
		}
	}
}
