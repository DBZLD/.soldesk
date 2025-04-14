package kioskV11;

public class ProcFood extends Product {
	boolean isSpoon;

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
