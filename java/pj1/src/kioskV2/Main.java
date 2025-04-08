package kioskV2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("==============       카페       ==============");
		System.out.println("============================================");
		Scanner sc;
		String userChoice;
		loopMain:
		while(true) {
			System.out.print("1.음료\n2.디저트\n3.나가기\n선택 : ");
			sc = new Scanner(System.in);
			userChoice = sc.next();
			switch(userChoice) {
			case "1":
				loopDrink:
					while(true) {
						System.out.println("음료 선택\n1.아이스 아메리카노\n2.에스프레소\n3.이전 메뉴로\n선택 : ");
						sc = new Scanner(System.in);
						userChoice = sc.next();
						switch(userChoice) {
						case "1":
							System.out.println("아이스 아메리카노 선택");
							break;
						case "2":
							System.out.println("에스프레소 선택");
							break;
						case "3":
							break loopDrink;
						}
					}
				break;
			case "2":
				loopFood:
					while(true) {
						System.out.println("디저트 선택\n1.케이크\n2.쿠키\n3.이전 메뉴로\n선택 : ");
						sc = new Scanner(System.in);
						userChoice = sc.next();
						switch(userChoice) {
						case "1":
							System.out.println("케이크 선택");
							break;
						case "2":
							System.out.println("쿠키 선택");
							break;
						case "3":
							break loopFood;
						}
					}
				break;
			case "3":
				break loopMain;
			}
		}
		System.out.println("프로그램 종료");
	}
}
