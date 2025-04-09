package kioskV9;

import java.util.Scanner;

public class ProcDrink {

	public static void OrderDrink() {
		loopDrink: while (true) {
			Display.DrinkMenuDisplay();
			Product.sc = new Scanner(System.in);
			Product.userChoice = Product.sc.next();
			switch (Product.userChoice) {
			case "1":
				Product.OrderMenu(Product.espresso);
				break;
			case "2":
				Product.OrderMenu(Product.americano);
				break;
			case "3":
				break loopDrink;
			}
		}
	}
}
