package function;

import java.util.Scanner;

public class EmployeeSearch {
	static public void ESearch() {
		System.out.println("정보를 검색할 직원의 이름을 입력해주세요.[e.나가기]");
		Scanner sc = new Scanner(System.in);
		String stInput = sc.next();
		if (stInput.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
	}
}
