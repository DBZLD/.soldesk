package function;

import java.util.Scanner;

import db.DbAccounts;

public class FunctionSign {
	static FunctionMain fMain = FunctionMain.getInstance();
	static Scanner sc;

	public static void SignIn() {
		System.out.print("아이디를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			System.out.println("취소");
			return;
		}
		System.out.print("비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			System.out.println("취소");
			return;
		}
		if (DbAccounts.DbSignIn(stId, stPw)) {
			System.out.println(stId + "님 환영합니다.");
			fMain.SetMyId(DbAccounts.aId);
			fMain.SetnPosition(DbAccounts.aPosition);
		} else {
			System.out.println("비밀번호 또는 아이디가 일치하지 않습니다.");
		}
	}

	public static void SignUp() {
		System.out.print("아이디를 입력해주세요(이름).[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stId = sc.next();
		if (stId.equals("e")) {
			System.out.println("취소");
			return;
		}
		System.out.print("비밀번호를 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		String stPw = sc.next();
		if (stPw.equals("e")) {
			System.out.println("취소");
			return;
		}
		if (DbAccounts.DbSignUp(stId, stPw)) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("알맞지 않은 아이디입니다.");
		}
	}

	public static void SignOut() {
		System.out.print("로그아웃 하시겠습니까?\n입력 : ");
		sc = new Scanner(System.in);
		String stInput = sc.next();
		if (stInput.equals("y")) {
			System.out.println("로그아웃 완료");
			fMain.SetMyId(null);
			fMain.SetnPosition("");
			return;
		} else if (stInput.equals("n")) {
			System.out.println("로그아웃 취소");
			return;
		} else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
	}
}
