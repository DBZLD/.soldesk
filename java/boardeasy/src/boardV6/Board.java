package boardV6;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Scanner scan;
	String stInput;
	ArrayList<Post> postList = new ArrayList<Post>();

	void Run() {
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

	void BoardLoop() {
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
				if (postList.size() <= 0) {
					System.out.println("글이 없습니다.\n");
					break;
				}
				System.out.println();
				for (int i = 0; i < postList.size(); i++) {
					System.out.println(postList.get(i).GetTitle() + "\n" + postList.get(i).GetContent() + "\n");
				}
				System.out.println("글 리스트 종료\n");
				break;
			case "3":
				System.out.println("\n글 삭제");
				for (int i = 0; i < postList.size(); i++) {
					System.out.println(postList.get(i).GetTitle() + " 삭제");
				}
				if (postList.size() <= 0) {
					System.out.println("글이 없습니다.\n");
					break;
				}
				System.out.println("입력 : ");
				scan = new Scanner(System.in);
				stInput = scan.next();
				postList.remove(Integer.parseInt(stInput) - 1);
				System.out.println(postList.get(Integer.parseInt(stInput) - 1).GetTitle() + " 삭제 완료\n");
				break;
			case "4":
				String shortInput;
				System.out.println("\n글 수정");
				for (int i = 0; i < postList.size(); i++) {
					System.out.println(postList.get(i).GetTitle() + " 수정");
				}
				if (postList.size() <= 0) {
					System.out.println("글이 없습니다.\n");
					break;
				}
				System.out.println("입력 : ");
				scan = new Scanner(System.in);
				stInput = scan.next();
				System.out.println(postList.get(Integer.parseInt(stInput) - 1).GetTitle() + "의 내용을 수정합니다\n입력 : ");
				scan = new Scanner(System.in);
				shortInput = scan.next();
				postList.get(Integer.parseInt(stInput) - 1).SetContent(shortInput);
				System.out.println(postList.get(Integer.parseInt(stInput) - 1).GetTitle() + " 수정 완료");
				break;
			case "5":
				return;
			}
		}
	}
}
