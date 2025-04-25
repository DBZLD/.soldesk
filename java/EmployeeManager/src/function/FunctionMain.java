package function;

import java.util.Scanner;

public class FunctionMain {
	private static FunctionMain singletonObject;
	public Scanner sc;
	public String stInput;
	String MyId = null;
	int nPosition = 0;

	public void Run() {
		boolean isAgain = true;
		while (isAgain) {
			if (MyId != null) {
				isAgain = SignInT();
			} else {
				isAgain = SignInF();
			}
		}
	}

	boolean SignInF() {
		System.out.println("직원 관리 프로그램");
		System.out.print("1.회원가입/2.로그인/e.나가기\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.next();
		if (stInput.equals("1")) {
			FunctionSign.SignUp();
		} else if (stInput.equals("2")) {
			FunctionSign.SignIn();
		} else if (stInput.equals("e")) {
			System.out.println("프로그램 종료");
			return false;
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		return true;
	}

	boolean SignInT() {
		System.out.println("직원 관리 프로그램");
		System.out.print("1.메인 메뉴/2.로그아웃/e.나가기\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.next();
		if (stInput.equals("1")) {
			LoopMain();
		} else if (stInput.equals("2")) {
			FunctionSign.SignOut();
		} else if (stInput.equals("e")) {
			System.out.println("프로그램 종료");
			return false;
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		return true;
	}

	void LoopMain() {
		while (true) {
			System.out.println("메인 메뉴");
			System.out.print("1.직원 리스트/2.직원 검색/3.직원 추가/4.직원 평가/5.직원 정보 수정/6.직원 제외/e.나가기\n입력 : ");
			sc = new Scanner(System.in);
			stInput = sc.next();
			switch (stInput) {
			case "1":
				EmployeeList.EList();
				break;
			case "2":
				EmployeeSearch.ESearch();
				break;
			case "3":
				EmployeeInsert.EInsert();
				break;
			case "4":
				EmployeeEvaluations.EEvaluations();
				break;
			case "5":
				EmployeeEdit.EEdit();
				break;
			case "6":
				EmployeeDelete.EDelete();
				break;
			case "e":
				System.out.println("초기 화면으로 돌아가기");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public void SetMyId(String id) {
		MyId = id;
	}

	public void SetnPosition(String position) {
		switch (position) {
		case "사원":
			nPosition = 1;
			break;
		case "주임":
			nPosition = 2;
			break;
		case "대리":
			nPosition = 3;
			break;
		case "과장":
			nPosition = 4;
			break;
		case "차장":
			nPosition = 5;
			break;
		case "부장":
			nPosition = 6;
			break;
		case "사장":
			nPosition = 7;
			break;
		case "":
			nPosition = 0;
			break;
		}
	}

	private FunctionMain() {

	}

	public static FunctionMain getInstance() {
		if (singletonObject == null) {
			singletonObject = new FunctionMain();
		}
		return singletonObject;
	}
}
