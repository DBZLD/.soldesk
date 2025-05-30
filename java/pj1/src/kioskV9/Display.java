package kioskV9;

public class Display {
	public static void TitleDisplay() {
		System.out.println("============================================");
		System.out.println("==============       카페       ==============");
		System.out.println("============================================");
	}

	public static void TotalMenuDisplay() {
		System.out.println(String.format("주문 내역\n에스프레소 : %d개\n아메리카노 : %d개\n케이크 : %d개\n쿠키 : %d개", Product.nCountEspresso,
				Product.nCountAmericano, Product.nCountCake, Product.nCountCookie));
		System.out.println(String.format("총 주문 금액 : %d원", Product.nTotalPrice));
	}

	public static void DrinkMenuDisplay() {
		System.out.println(String.format("\n음료 선택\n1.%s\n2.%s\n3.이전 메뉴로\n선택 : ", Product.espresso.Info(),
				Product.americano.Info()));
	}

	public static void FoodMenuDisplay() {
		System.out.println(
				String.format("\n디저트 선택\n1.%s\n2.%s\n3.이전 메뉴로\n선택 : ", Product.cake.Info(), Product.cookie.Info()));
	}
}
