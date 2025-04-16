package boardV9;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Board {
	private static Board singleton = new Board();

	Scanner scan;
	String stInput;
	ArrayList<Post> postList = new ArrayList<Post>();
	Date dNow;
	SimpleDateFormat formDate = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
	String stDate;

	void Run() {
		while (true) {
			System.out.print("[1.글 리스트/2.글 읽기/3.글 쓰기/4.글 삭제/5.글 수정/e.프로그램 나가기]\n입력 : ");
			scan = new Scanner(System.in);
			stInput = scan.next();
			switch (stInput) {
			case "1":
				ListPost();
				break;
			case "2":
				ReadPost();
				break;
			case "3":
				WritePost();
				break;
			case "4":
				DeletePost();
				break;
			case "5":
				ResetPost();
				break;
			case "e":
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	void ReadPost() {
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		System.out.println("\n글 읽기\n읽을 글의 번호를 입력해주세요.[e.메뉴로 나가기]");
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("\n%d. %s(글쓴이 : %s) [%s] \n", i + 1, postList.get(i).GetTitle(),
					postList.get(i).GetWriter(), postList.get(i).GetDate()));
		}
		System.out.print("입력 : ");
		scan = new Scanner(System.in);
		String stInput = scan.next();
		if (stInput.equals("e")) {
			System.out.println("글 읽기 종료\n");
			return;
		}
		int nCatch = 0;
		try {
			nCatch = Integer.parseInt(stInput);
			postList.get(nCatch - 1);
		} catch (NumberFormatException e) {
			System.out.println("잘못된 값을 입력했습니다.\n");
			return;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("잘못된 값을 입력했습니다.\n");
			return;
		}
		postList.get(nCatch - 1).ReadPost();
	}

	void WritePost() {
		System.out.print("\n글 쓰기\n제목을 입력해주세요.[e.메뉴로 나가기] : ");
		scan = new Scanner(System.in);
		String stTitle = scan.nextLine();
		if (stTitle.equals("e")) {
			System.out.println("글 쓰기 종료\n");
			return;
		}
		System.out.println("입력 완료\n");
		System.out.print("저자를 입력해주세요. : ");
		scan = new Scanner(System.in);
		String stWriter = scan.nextLine();
		System.out.println("입력 완료\n");
		System.out.print("내용을 입력해주세요. : ");
		scan = new Scanner(System.in);
		String stContent = scan.nextLine();
		dNow = new Date();
		stDate = formDate.format(dNow);
		postList.add(new Post(stTitle, stWriter, stContent, stDate));
		System.out.println("입력 완료\n");
		return;
	}

	void ListPost() {
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		System.out.println("글 리스트");
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("\n%d. %s(글쓴이 : %s) [%s] \n", i + 1, postList.get(i).GetTitle(),
					postList.get(i).GetWriter(), postList.get(i).GetDate()));
		}
		System.out.println("글 리스트 종료\n");
		return;
	}

	void DeletePost() {
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		System.out.println("\n글 삭제\n삭제할 글의 번호를 입력해주세요.[e.메뉴로 나가기]\n");
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("%d. %s 삭제", i + 1, postList.get(i).GetTitle()));
		}
		System.out.print("입력 : ");
		scan = new Scanner(System.in);
		stInput = scan.next();
		if (stInput.equals("e")) {
			System.out.println("글 삭제 종료\n");
			return;
		}
		int nCatch = 0;
		try {
			nCatch = Integer.parseInt(stInput);
			postList.get(nCatch - 1);
		} catch (NumberFormatException e) {
			System.out.println("잘못된 값을 입력했습니다.\n");
			return;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("잘못된 값을 입력했습니다.\n");
			return;
		}
		System.out.println(String.format("%s 삭제 완료\n", postList.get(nCatch - 1).GetTitle()));
		postList.remove(nCatch - 1);
		return;
	}

	void ResetPost() {
		String shortInput;
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		System.out.println("\n글 수정\n수정할 글의 번호를 입력해주세요.[e.메뉴로 나가기]\n");
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("%d. %s 수정", i + 1, postList.get(i).GetTitle()));
		}
		System.out.print("입력 : ");
		scan = new Scanner(System.in);
		stInput = scan.next();
		if (stInput.equals("e")) {
			System.out.println("글 수정 종료\n");
			return;
		}
		int nCatch = 0;
		try {
			nCatch = Integer.parseInt(stInput);
			postList.get(nCatch - 1);
		} catch (NumberFormatException e) {
			System.out.println("잘못된 값을 입력했습니다.\n");
			return;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("잘못된 값을 입력했습니다.\n");
			return;
		}
		System.out.print(String.format("%s의 내용을 수정합니다.\n입력 : ", postList.get(nCatch - 1).GetTitle()));
		scan = new Scanner(System.in);
		shortInput = scan.nextLine();
		postList.get(nCatch - 1).SetContent(shortInput);
		System.out.println(String.format("%s 수정 완료", postList.get(nCatch - 1).GetTitle()));
		return;
	}

	private Board() {

	}

	static Board getInstance() {
		return singleton;
	}
}
