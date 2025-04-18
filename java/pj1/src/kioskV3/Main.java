package kioskV3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("==============       카페       ==============");
		System.out.println("============================================");
		Scanner sc;
		String userChoice;
		Product espresso = new Product("에스프레소", 2000);
		Product americano = new Product("아메리카노", 1000);
		Product cake = new Product("케이크", 5000);
		Product cookie = new Product("쿠키", 4000);
		loopMain:
		while(true) {
			System.out.print("1.음료\n2.디저트\n3.나가기\n선택 : ");
			sc = new Scanner(System.in);
			userChoice = sc.next();
			switch(userChoice) {
			case "1":
				loopDrink:
					while(true) {
						System.out.println("음료 선택\n1." + espresso.Info() + "\n2." + americano.Info() + "\n3.이전 메뉴로\n선택 : ");
						sc = new Scanner(System.in);
						userChoice = sc.next();
						switch(userChoice) {
						case "1":
							System.out.println(espresso.stName + " 선택");
							break;
						case "2":
							System.out.println(americano.stName + " 선택");
							break;
						case "3":
							break loopDrink;
						}
					}
				break;
			case "2":
				loopFood:
					while(true) {
						System.out.println("디저트 선택\n1." + cake.Info() + "\n2." + cookie.Info() + "\n3.이전 메뉴로\n선택 : ");
						sc = new Scanner(System.in);
						userChoice = sc.next();
						switch(userChoice) {
						case "1":
							System.out.println(cake.stName + " 선택");
							break;
						case "2":
							System.out.println(cookie.stName + " 선택");
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
