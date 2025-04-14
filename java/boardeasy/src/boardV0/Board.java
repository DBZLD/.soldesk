package boardV0;

import java.util.Scanner;

public class Board {
	static Scanner scan;
	static String stInput;

	static void Run() {
		while (true) {
			System.out.println("1.글쓰기\n2.글리스트\n3.나가기\n입력 : ");
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				return;
			}
		}
	}
}
