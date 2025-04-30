package function;

import java.util.Scanner;

import db.DbMain;
import display.Display;

public class EmployeeEdit {
	static public void EEdit() {
		Display.Line();
		System.out.print("정보를 수정할 직원의 이름을 입력해주세요.[e.나가기]");
		DbMain.DbNameListEmployee();
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		String stName = sc.next();
		if (stName.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		Display.Line();
		System.out.println("수정할 정보의 종류를 입력해주세요.[e.나가기]");
		System.out.print("이름/나이/직책/성별/입사일/연봉\n입력: ");
		sc = new Scanner(System.in);
		String stInput = sc.next();
		switch (stInput) {
		case "이름":
			stInput = "e_name";
			break;
		case "나이":
			stInput = "e_age";
			break;
		case "성별":
			stInput = "e_gender";
			break;
		case "직책":
			stInput = "e_position";
			break;
		case "입사일":
			stInput = "e_join_date";
			break;
		case "연봉":
			stInput = "e_annual_income";
			break;
		case "e":
			System.out.println("메인 메뉴로 나가기");
			return;
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
		Display.Line();
		System.out.println("수정할 내용을 입력해주세요.[e.나가기]");
		sc = new Scanner(System.in);
		String stText = sc.next();
		if (stInput.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		if (DbMain.DbEditEmployee(stName, stText, stInput)) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
	}
}
