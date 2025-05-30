package boardV4;

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
				DeletePostListLoop();
				break;
			case "4":
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
		System.out.println("아무키나 입력하면 돌아갑니다.");
		scan = new Scanner(System.in);
		stInput = scan.next();
		if (scan != null) {
			return;
		}
	}

	static void DeletePostListLoop() {
		Display.DeletePostListDisplay();
		scan = new Scanner(System.in);
		stInput = scan.next();
		postList.remove(Integer.parseInt(stInput) - 1);
	}

	static void Run() {
		MainLoop();
	}
}
