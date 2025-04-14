package boardV0;

import java.util.Scanner;

public class Function {
	static Scanner scan;
	static String stInput;

	static void MainLoop() {
		while (true) {
			Display.TitleDisplay();
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				Display.WriteMenu1Display();
				break;
			case "2":
				break;
			case "3":
				return;
			}
		}
	}

	static void WriteLoop() {
		while (true) {
			Display.WriteMenu1Display();
			scan = new Scanner(System.in);
			stInput = scan.next();
		}
	}

	static void Run() {
		MainLoop();
	}
}
