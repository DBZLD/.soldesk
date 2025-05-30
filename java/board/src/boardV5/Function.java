package boardV5;

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
				PostList();
				break;
			case "3":
				DeletePostListLoop();
				break;
			case "4":
				ResetPostListLoop();
				break;
			case "5":
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

	static void PostList() {
		Display.PostListDisplay();
		System.out.println("아무키나 입력하면 돌아갑니다.");
		scan = new Scanner(System.in);
		stInput = scan.next();
		if (scan != null) {
			return;
		}
	}

	static void DeletePostListLoop() {
		while (true) {
			Display.DeletePostListDisplay();
			scan = new Scanner(System.in);
			stInput = scan.next();
			if (stInput.equals("e")) {
				System.out.println("글 삭제 종료");
				return;
			}
			postList.remove(Integer.parseInt(stInput) - 1);
		}
	}

	static void ResetPostListLoop() {
		String shortInput;
		while (true) {
			Display.ResetPostListDisplay();
			scan = new Scanner(System.in);
			stInput = scan.next();
			if (stInput.equals("e")) {
				System.out.println("글 수정 종료");
				return;
			}
			System.out.println(Integer.parseInt(stInput) + "번글의 내용을 재설정합니다 e.나가기");
			scan = new Scanner(System.in);
			shortInput = scan.next();
			if (shortInput.equals("e")) {
				System.out.println("글 수정 종료");
				return;
			}
			postList.get(Integer.parseInt(stInput) - 1).stContent = shortInput;
		}
	}

	static void Run() {
		MainLoop();
	}
}
