package boardV4;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	static Scanner scan;
	static String stInput;
	static ArrayList<Post> postList = new ArrayList<Post>();

	static void Run() {
		mainLoop: while (true) {
			System.out.println("1.게시판\n2.나가기\n입력 : ");
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				BoardLoop();
				break;
			case "2":
				break mainLoop;
			}
		}
	}

	static void BoardLoop() {
		while (true) {
			System.out.println("1.글 쓰기\n2.글 리스트\n3.글 삭제\n4.나가기\n입력 : ");
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				System.out.println("\n글쓰기\n내용을 입력해주세요. : ");
				scan = new Scanner(System.in);
				stInput = scan.next();
				postList.add(new Post(stInput));
				System.out.println("입력 완료\n");
				break;
			case "2":
				System.out.println();
				for (int i = 0; i < postList.size(); i++) {
					System.out.println((i + 1) + "번\n" + postList.get(i).stContent + "\n");
				}
				System.out.println("글 리스트 종료\n");
				break;
			case "3":
				System.out.println("\n글 삭제");
				for (int i = 0; i < postList.size(); i++) {
					System.out.println((i + 1) + "번글 삭제");
				}
				System.out.println("입력 : ");
				scan = new Scanner(System.in);
				stInput = scan.next();
				postList.remove(Integer.parseInt(stInput) - 1);
				System.out.println(Integer.parseInt(stInput) + "번글 삭제 완료\n");
				break;
			case "4":
				return;
			}
		}
	}

	static void PostListLoop() {
		System.out.println();
		for (int i = 0; i < postList.size(); i++) {
			System.out.println((i + 1) + "번\n" + postList.get(i).stContent + "\n");
		}
		System.out.println("e.나가기");
		scan = new Scanner(System.in);
		stInput = scan.next();
		if (stInput == "e") {
			System.out.println("글 리스트 종료");
			return;
		}
	}
}
