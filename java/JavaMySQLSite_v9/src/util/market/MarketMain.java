package util.market;

import java.util.Scanner;

import display.Display;

public class MarketMain {
	static Scanner sc;
	static String stInput;
	static public String marketName = "장터";

	public static void MarketLoop() {
		while (true) {
			Display.ShowMarketTitle();
			Display.MarketMenu();
			sc = new Scanner(System.in);
			stInput = sc.nextLine();
			switch (stInput) {
			case "1":
				MarketList.MarketListMenu();
				break;
			case "2":
				MarketRead.MarketReadMenu();
				break;
			case "3":
				MarketWrite.MarketWriteMenu();
				break;
			case "4":
				MarketDelete.MarketDeleteMenu();
				break;
			case "5":
				MarketReset.MarketResetMenu();
				break;
			case "6":
				MarketWriteComments.BoardCommentsMenu();
				break;
			case "e":
				System.out.println("메인 메뉴로 나가기");
				return;
			}
		}
	}

	static public void ChangeMatcketName() {
		System.out.print("변경할 이름을 입력해주세요.[e.나가기]\n입력 : ");
		sc = new Scanner(System.in);
		stInput = sc.nextLine();
		if (stInput.equals("e")) {
			System.out.println("메인 메뉴로 나가기");
			return;
		}
		marketName = stInput;
		System.out.println("이름 변경 완료");
	}
}
