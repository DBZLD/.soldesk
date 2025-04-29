package function;

import java.util.Scanner;

import db.DbMain;

public class EmployeeInsert {
	static public void EInsert() {
		System.out.println("추가할 직원의 이름을 입력해주세요.[e.나가기]");
		Scanner sc = new Scanner(System.in);
		String stName = sc.next();
		if (stName.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		System.out.println("추가할 직원의 직책을 입력해주세요.[e.나가기]");
		sc = new Scanner(System.in);
		String stPosition = sc.next();
		if (stName.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		System.out.println("추가할 직원의 나이를 입력해주세요.[e.나가기]");
		sc = new Scanner(System.in);
		String stAge = sc.next();
		if (stName.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		System.out.println("추가할 직원의 성별을 입력해주세요.[e.나가기]");
		sc = new Scanner(System.in);
		String stGender = sc.next();
		if (stName.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		System.out.println("추가할 직원의 연봉을 입력해주세요.[e.나가기]");
		sc = new Scanner(System.in);
		String stIncome = sc.next();
		if (stName.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		DbMain.DbInsertEmployee(stName, stPosition, stAge, stIncome, stGender);
	}
}
