package function;

import java.util.Scanner;

public class EmployeeEvaluations {
	static public void EEvaluations() {
		System.out.println("평가를 적을 직원의 이름을 입력해주세요.[e.나가기]");
		Scanner sc = new Scanner(System.in);
		String stInput = sc.next();
		if (stInput.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
	}
}
