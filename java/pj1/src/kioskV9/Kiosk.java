package kioskV9;

import java.util.Scanner;

public class Kiosk {
	public void Run() {
		Display.TitleDisplay();
		Product.SetProductList();
		loopMain: while (true) {
			System.out.print("1.음료\n2.디저트\n3.주문 내역 보기\n4.나가기\n선택 : ");
			Product.sc = new Scanner(System.in);
			Product.userChoice = Product.sc.next();
			switch (Product.userChoice) {
			case "1":
				ProcDrink.OrderDrink();
				break;
			case "2":
				ProcFood.OrderFood();
				break;
			case "3":
				if (Product.orderList.size() <= 0) {
					System.out.println("\n주문내역이 없습니다.\n");
				}
				Product.CountTotalMenu();
				Display.TotalMenuDisplay();
				break;
			case "4":
				break loopMain;
			}
		}
		System.out.println("프로그램 종료");
	}
}
