package boardV1;

import java.util.ArrayList;
import java.util.Scanner;

public class Function {
	static Scanner scan;
	static String stInput;
	static ArrayList<Post> postList = new ArrayList<Post>();

	static void MainLoop() {
		while (true) {
			Display.TitleDisplay();
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				WriteLoop();
				break;
			case "2":
				PostListLoop();
				break;
			case "3":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	static void WriteLoop() {
		while (true) {
			Display.WriteMenu1Display();
			scan = new Scanner(System.in);
			stInput = scan.next();
			postList.add(new Post(stInput));
			System.out.println("입력 완료\n");
			return;
		}
	}

	static void PostListLoop() {
		Display.PostListDisplay();
		scan = new Scanner(System.in);
		stInput = scan.next();
		if (scan != null) {
			return;
		}
	}

	static void Run() {
		MainLoop();
	}
}
