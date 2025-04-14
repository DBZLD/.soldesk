package kioskV9;

import java.util.Scanner;

public class ProcFood {
	public static void OrderFood() {
		loopFood: while (true) {
			Display.FoodMenuDisplay();
			Product.sc = new Scanner(System.in);
			Product.userChoice = Product.sc.next();
			switch (Product.userChoice) {
			case "1":
				Product.OrderMenu(Product.cake);
				break;
			case "2":
				Product.OrderMenu(Product.cookie);
				break;
			case "3":
				break loopFood;
			}
		}
	}
}
