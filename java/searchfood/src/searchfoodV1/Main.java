package searchfoodV1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HashMap<String, Food> foodHash = new HashMap<>();
		Scanner input;
		String stInput;
		String stInputMenu;
		foodHash.put("우동", new Food("우동", 8000, true));
		foodHash.put("회", new Food("회", 20000, false));
		foodHash.put("초밥", new Food("초밥", 10000, false));
		foodHash.put("라멘", new Food("라멘", 9000, true));

		while (true) {
			System.out.println("음식 검색 메인 메뉴\n1.음식 리스트\n2.음식 주문\n3.나가기");
			input = new Scanner(System.in);
			stInput = input.next();
			switch (stInput) {
			case "1":
				for (Food food : foodHash.values()) {
					food.Info();
				}
				break;
			case "2":
				loopOrder: while (true) {
					System.out.println("주문할 음식을 검색해주세요\n입력 : ");
					input = new Scanner(System.in);
					stInputMenu = input.next();
					if (!foodHash.containsKey(stInputMenu)) {
						System.out.println(stInputMenu + "은(는)메뉴에 없는 음식입니다.");
						break;
					}
					System.out.println(stInputMenu + "을(를) 주문하시겠습니까?\n수락(y)/거절(n) : ");
					input = new Scanner(System.in);
					stInput = input.next();
					if (stInput.equals("y")) {
						foodHash.get(stInputMenu).Info();
						System.out.println("주문 완료");
						break loopOrder;
					} else if (stInput.equals("n")) {
						System.out.println("주문을 취소하셨습니다.");
						break loopOrder;
					}
				}
				break;
			case "3":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}
}
