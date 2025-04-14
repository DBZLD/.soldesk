package kioskV10;

public class ProcFood extends Product {
	boolean isSpoon;

	public static void OrderFood() {
		loopFood: while (true) {
			Display.FoodMenuDisplay();
			switch (Function.SearchChoice()) {
			case "1":
				Function.OrderMenu(Function.cake);
				break;
			case "2":
				Function.OrderMenu(Function.cookie);
				break;
			case "3":
				break loopFood;
			}
		}
	}

	public String Info() {
		String shortInfo;
		shortInfo = stName + "(" + nPrice + "원)";
		if (this.isSpoon == true) {
			shortInfo += " 수저 제공";
		} else {
			shortInfo += " 수저 미제공";
		}
		return shortInfo;
	}

	ProcFood(String name, int price, boolean spoon) {
		super(name, price);
		isSpoon = spoon;
	}
}
