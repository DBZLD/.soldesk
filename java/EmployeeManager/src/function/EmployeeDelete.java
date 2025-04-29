package function;

import java.util.Scanner;

import db.DbMain;
import display.Display;

public class EmployeeDelete {
	static public void EDelete() {
		Display.Line();
		System.out.println("제외할 직원의 이름을 입력해주세요.[e.나가기]");
		DbMain.DbNameListEmployee();
		Display.Line();
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		String stInput = sc.next();
		if (stInput.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		if (DbMain.DbDeleteEmployee(stInput)) {
			Display.Line();
			System.out.println("성공");
		} else {
			Display.Line();
			System.out.println("이름이 일치하는 직원이 없습니다.");
		}
	}
}
