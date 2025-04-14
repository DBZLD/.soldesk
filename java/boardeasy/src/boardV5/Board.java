package boardV5;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	static Scanner scan;
	static String stInput;
	static ArrayList<Post> postList = new ArrayList<Post>();

	static void Run() {
		while (true) {
			System.out.println("1.게시판\n2.나가기\n입력 : ");
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				BoardLoop();
				break;
			case "2":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	static void BoardLoop() {
		while (true) {
			System.out.println("1.글 쓰기\n2.글 리스트\n3.글 삭제\n4.글 수정\n5.나가기\n입력 : ");
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				System.out.println("\n글쓰기\n제목을 입력해주세요. : ");
				scan = new Scanner(System.in);
				String stTitle = scan.next();
				System.out.println("입력 완료\n");
				System.out.println("내용을 입력해주세요. : ");
				scan = new Scanner(System.in);
				String stContent = scan.next();
				postList.add(new Post(stTitle, stContent));
				System.out.println("입력 완료\n");
				break;
			case "2":
				System.out.println();
				for (int i = 0; i < postList.size(); i++) {
					System.out.println(postList.get(i).stTitle + "\n" + postList.get(i).stContent + "\n");
				}
				System.out.println("글 리스트 종료\n");
				break;
			case "3":
				System.out.println("\n글 삭제");
				for (int i = 0; i < postList.size(); i++) {
					System.out.println(postList.get(i).stTitle + " 삭제");
				}
				System.out.println("입력 : ");
				scan = new Scanner(System.in);
				stInput = scan.next();
				postList.remove(Integer.parseInt(stInput) - 1);
				System.out.println(postList.get(Integer.parseInt(stInput) - 1).stTitle + " 삭제 완료\n");
				break;
			case "4":
				ResetLoop: while (true) {
					String shortInput;
					System.out.println("\n글 수정");
					for (int i = 0; i < postList.size(); i++) {
						System.out.println(postList.get(i).stTitle + " 재입력");
					}
					System.out.println("입력 : ");
					scan = new Scanner(System.in);
					stInput = scan.next();
					System.out.println(postList.get(Integer.parseInt(stInput) - 1).stTitle + "의 내용을 재설정합니다\n입력 : ");
					scan = new Scanner(System.in);
					shortInput = scan.next();
					postList.get(Integer.parseInt(stInput) - 1).stContent = shortInput;
					System.out.println(postList.get(Integer.parseInt(stInput) - 1).stTitle + " 수정 완료");
					break ResetLoop;
				}
			case "5":
				return;
			}
		}
	}
}
