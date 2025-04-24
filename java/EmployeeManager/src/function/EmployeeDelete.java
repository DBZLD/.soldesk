package function;

import java.util.Scanner;

public class EmployeeDelete {
	static public void EDelete() {
		System.out.println("제외할 직원의 이름을 입력해주세요.[e.나가기]");
		Scanner sc = new Scanner(System.in);
		String stInput = sc.next();
		if (stInput.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
	}
}
