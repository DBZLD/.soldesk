package kioskV7;

import java.util.Scanner;

public class ProcFood {
	public static void OrderFood() {
		loopFood: while (true) {
			System.out.println("\n디저트 선택\n1." + Kiosk.cake.Info() + "\n2." + Kiosk.cookie.Info() + "\n3.이전 메뉴로\n선택 : ");
			Kiosk.sc = new Scanner(System.in);
			Kiosk.userChoice = Kiosk.sc.next();
			switch (Kiosk.userChoice) {
			case "1":
				System.out.println(Kiosk.cake.stName + " 을(를)주문 내역에 추가");
				Kiosk.choiceMenu.add(Kiosk.cake);
				break;
			case "2":
				System.out.println(Kiosk.cookie.stName + " 을(를)주문 내역에 추가");
				Kiosk.choiceMenu.add(Kiosk.cookie);
				break;
			case "3":
				break loopFood;
			}
		}
	}
}
