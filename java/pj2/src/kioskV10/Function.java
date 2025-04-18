package kioskV10;

import java.util.ArrayList;
import java.util.Scanner;

public class Function {
	static Scanner sc;
	static String userChoice;
	static ProcDrink espresso = new ProcDrink("에스프레소", 2000, true);
	static ProcDrink americano = new ProcDrink("아메리카노", 1000, false);
	static ProcFood cake = new ProcFood("케이크", 5000, true);
	static ProcFood cookie = new ProcFood("쿠키", 4000, false);
	static ArrayList<Product> orderList = new ArrayList<Product>();
	static ArrayList<Product> productList = new ArrayList<Product>();
	static int nCountEspresso;
	static int nCountAmericano;
	static int nCountCake;
	static int nCountCookie;
	static int nTotalPrice = 0;

	public static void SetProductList() {
		productList.add(espresso);
		productList.add(americano);
		productList.add(cake);
		productList.add(cookie);
	}

	public static String SearchChoice() {
		sc = new Scanner(System.in);
		userChoice = sc.next();
		return userChoice;
	}

	public static void OrderMenu(Product pro) {
		System.out.println(pro.stName + " 을(를)주문 내역에 추가");
		orderList.add(pro);
	}

	public static void CountTotalMenu() {
		nCountEspresso = 0;
		nCountAmericano = 0;
		nCountCake = 0;
		nCountCookie = 0;
		nTotalPrice = 0;
		for (Product pro : orderList) {
			if (pro.stName.equals("에스프레소")) {
				nCountEspresso++;
				nTotalPrice += espresso.nPrice;
			} else if (pro.stName.equals("아메리카노")) {
				nCountAmericano++;
				nTotalPrice += americano.nPrice;
			} else if (pro.stName.equals("케이크")) {
				nCountCake++;
				nTotalPrice += cake.nPrice;
			} else if (pro.stName.equals("쿠키")) {
				nCountCookie++;
				nTotalPrice += cookie.nPrice;
			}
		}
	}
}
