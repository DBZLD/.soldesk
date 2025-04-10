package kioskV11;

public class ProcDrink extends Product {

	boolean isHot;

	public String Info() {
		String shortInfo;
		shortInfo = stName + "(" + nPrice + "원)";
		if (this.isHot == true) {
			shortInfo += " 뜨거운 음료";
		} else {
			shortInfo += " 차가운 음료";
		}
		return shortInfo;
	}

	ProcDrink(String name, int price, boolean hot) {
		super(name, price);
		this.isHot = hot;
	}
}
