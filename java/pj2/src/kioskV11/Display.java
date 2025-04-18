package kioskV11;

public class Display {
	public static void TitleDisplay() {
		System.out.println("============================================");
		System.out.println("==============       카페       ==============");
		System.out.println("============================================");
	}

	public static void TotalMenuDisplay() {
		String shortCount = "주문 내역\n";
		if (Function.nCountEspresso > 0) {
			shortCount += "\n에스프레소 : " + Function.nCountEspresso + "개";
		}
		if (Function.nCountAmericano > 0) {
			shortCount += "\n아메리카노 : " + Function.nCountAmericano + "개";
		}
		if (Function.nCountCake > 0) {
			shortCount += "\n케이크 : " + Function.nCountCake + "개";
		}
		if (Function.nCountCookie > 0) {
			shortCount += "\n쿠키 : " + Function.nCountCookie + "개";
		}
		System.out.println(shortCount);
		System.out.println(String.format("총 주문 금액 : %d원", Function.nTotalPrice));
	}

	public static void DrinkMenuDisplay() {
		System.out.println("\n음료 선택\n");
		int j = 1;
		for (Product pro : Function.productList) {
			if (pro instanceof ProcDrink) {
				System.out.println(j + "." + pro.Info());
				j++;
			}
		}
		System.out.println("3.이전 메뉴로\n선택 : ");
	}

	public static void FoodMenuDisplay() {
		System.out.println("\n음식 선택\n");
		int j = 1;
		for (Product pro : Function.productList) {
			if (pro instanceof ProcFood) {
				System.out.println(j + "." + pro.Info());
				j++;
			}
		}
		System.out.println("3.이전 메뉴로\n선택 : ");
	}
}
