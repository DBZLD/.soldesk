package kioskV10;

public class Kiosk {
	public void Run() {
		Display.TitleDisplay();
		Function.SetProductList();
		loopMain: while (true) {
			System.out.print("1.음료\n2.디저트\n3.주문 내역 보기\n4.나가기\n선택 : ");
			switch (Function.SearchChoice()) {
			case "1":
				ProcDrink.OrderDrink();
				break;
			case "2":
				ProcFood.OrderFood();
				break;
			case "3":
				if (Function.orderList.size() <= 0) {
					System.out.println("\n주문내역이 없습니다.\n");
				} else {
					Function.CountTotalMenu();
					Display.TotalMenuDisplay();
				}
				break;
			case "4":
				break loopMain;
			}
		}
		System.out.println("프로그램 종료");
	}
}
