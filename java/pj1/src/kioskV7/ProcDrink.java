package kioskV7;

import java.util.Scanner;

public class ProcDrink {

	public static void OrderDrink() {
		loopDrink: while (true) {
			System.out.println(
					"\n음료 선택\n1." + Kiosk.espresso.Info() + "\n2." + Kiosk.americano.Info() + "\n3.이전 메뉴로\n선택 : ");
			Kiosk.sc = new Scanner(System.in);
			Kiosk.userChoice = Kiosk.sc.next();
			switch (Kiosk.userChoice) {
			case "1":
				System.out.println(Kiosk.espresso.stName + " 을(를)주문 내역에 추가");
				Kiosk.choiceMenu.add(Kiosk.espresso);
				break;
			case "2":
				System.out.println(Kiosk.americano.stName + " 을(를)주문 내역에 추가");
				Kiosk.choiceMenu.add(Kiosk.americano);
				break;
			case "3":
				break loopDrink;
			}
		}
	}
}
