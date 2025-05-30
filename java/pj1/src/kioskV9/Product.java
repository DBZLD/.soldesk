package kioskV9;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	static Scanner sc;
	static String userChoice;
	static Product espresso = new Product("에스프레소", 2000);
	static Product americano = new Product("아메리카노", 1000);
	static Product cake = new Product("케이크", 5000);
	static Product cookie = new Product("쿠키", 4000);
	static ArrayList<Product> orderList = new ArrayList<Product>();
	static ArrayList<Product> productList = new ArrayList<Product>();
	static int nCountEspresso;
	static int nCountAmericano;
	static int nCountCake;
	static int nCountCookie;
	static int nTotalPrice = 0;

	String stName;
	int nPrice;

	public String Info() {
		return stName + "(" + nPrice + "원)";
	}

	public static void SetProductList() {
		productList.add(espresso);
		productList.add(americano);
		productList.add(cake);
		productList.add(cookie);
	}

	public static void OrderMenu(Product pro) {
		System.out.println(pro.stName + " 을(를)주문 내역에 추가");
		Product.orderList.add(pro);
	}

	public static void CountTotalMenu() {
		for (Product pro : orderList) {
			if (pro.stName.equals("에스프레소")) {
				nCountEspresso++;
				nTotalPrice += Product.espresso.nPrice;
			} else if (pro.stName.equals("아메리카노")) {
				nCountAmericano++;
				nTotalPrice += Product.americano.nPrice;
			} else if (pro.stName.equals("케이크")) {
				nCountCake++;
				nTotalPrice += Product.cake.nPrice;
			} else if (pro.stName.equals("쿠키")) {
				nCountCookie++;
				nTotalPrice += Product.cookie.nPrice;
			}
		}
	}

	Product(String stName, int nPrice) {
		this.stName = stName;
		this.nPrice = nPrice;
	}

	Product(int nPrice, String stName) {
		this.nPrice = nPrice;
		this.stName = stName;
	}
}
