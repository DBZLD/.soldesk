package kioskV8;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
	static Scanner sc;
	static String userChoice;
	static Product espresso = new Product("에스프레소", 2000);
	static Product americano = new Product("아메리카노", 1000);
	static Product cake = new Product("케이크", 5000);
	static Product cookie = new Product("쿠키", 4000);
	static ArrayList<Product> choiceMenu = new ArrayList<Product>();

	public void Run() {
		Display.TitleDisplay();
		loopMain: while (true) {
			System.out.print("1.음료\n2.디저트\n3.주문 내역 보기\n4.나가기\n선택 : ");
			sc = new Scanner(System.in);
			userChoice = sc.next();
			switch (userChoice) {
			case "1":
				ProcDrink.OrderDrink();
				break;
			case "2":
				ProcFood.OrderFood();
				break;
			case "3":
				int nTotalPrice = 0;
				if (choiceMenu.size() <= 0) {
					System.out.println("\n주문내역이 없습니다.\n");
				}
				for (Product cMenu : choiceMenu) {
					System.out.println(cMenu.stName);
					nTotalPrice += cMenu.nPrice;
				}
				System.out.println("총 주문 금액 : " + nTotalPrice);
				break;
			case "4":
				break loopMain;
			}
		}
		System.out.println("프로그램 종료");
	}
}
