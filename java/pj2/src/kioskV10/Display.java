package kioskV10;

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
			shortCount += "\n아메리카노 : " + Function.nCountEspresso + "개";
		}
		if (Function.nCountCake > 0) {
			shortCount += "\n케이크 : " + Function.nCountEspresso + "개";
		}
		if (Function.nCountCookie > 0) {
			shortCount += "\n쿠키 : " + Function.nCountEspresso + "개";
		}
		System.out.println(shortCount);
		System.out.println(String.format("총 주문 금액 : %d원", Function.nTotalPrice));
	}

	public static void DrinkMenuDisplay() {
		System.out.println(String.format("\n음료 선택\n1.%s\n2.%s\n3.이전 메뉴로\n선택 : ", Function.espresso.Info(),
				Function.americano.Info()));
	}

	public static void FoodMenuDisplay() {
		System.out.println(
				String.format("\n디저트 선택\n1.%s\n2.%s\n3.이전 메뉴로\n선택 : ", Function.cake.Info(), Function.cookie.Info()));
	}
}
