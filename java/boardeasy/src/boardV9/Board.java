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
	Date now;
	SimpleDateFormat formDate = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
	String stDate;

	void Run() {
		while (true) {
			System.out.println("[1.게시판/2.나가기]\n입력 : ");
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
			System.out.println("[1.글 리스트/2.글 읽기/3.글 쓰기/4.글 삭제/5.글 수정/e.나가기]\n입력 : ");
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
				return;
			}
		}
	}

	void ReadPost() {
		System.out.println("\n글 읽기\n읽을 글의 번호를 입력해주세요. : ");
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("\n%s(%s) [%s] \n", postList.get(i).GetTitle(),
					postList.get(i).GetWriter(), postList.get(i).GetDate()));
		}
		scan = new Scanner(System.in);
		String stInput = scan.next();
		postList.get(Integer.parseInt(stInput)).ReadPost();
	}

	void WritePost() {
		System.out.println("\n글쓰기\n제목을 입력해주세요. : ");
		scan = new Scanner(System.in);
		String stTitle = scan.next();
		System.out.println("입력 완료\n");
		System.out.println("저자를 입력해주세요. : ");
		scan = new Scanner(System.in);
		String stWriter = scan.next();
		System.out.println("입력 완료\n");
		System.out.println("내용을 입력해주세요. : ");
		scan = new Scanner(System.in);
		String stContent = scan.next();
		now = new Date();
		stDate = formDate.format(now);
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
			System.out.println(String.format("\n%s(%s) [%s] \n", postList.get(i).GetTitle(),
					postList.get(i).GetWriter(), postList.get(i).GetDate()));
		}
		System.out.println("글 리스트 종료\n");
		return;
	}

	void DeletePost() {
		System.out.println("\n글 삭제");
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("%s 삭제", postList.get(i).GetTitle()));
		}
		System.out.println("입력 : ");
		scan = new Scanner(System.in);
		stInput = scan.next();
		System.out.println(String.format("%s 삭제 완료\n", postList.get(Integer.parseInt(stInput) - 1).GetTitle()));
		postList.remove(Integer.parseInt(stInput) - 1);
		return;
	}

	void ResetPost() {
		String shortInput;
		System.out.println("\n글 수정");
		if (postList.size() <= 0) {
			System.out.println("글이 없습니다.\n");
			return;
		}
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(String.format("%s 수정", postList.get(i).GetTitle()));
		}
		System.out.println("입력 : ");
		scan = new Scanner(System.in);
		stInput = scan.next();
		System.out
				.println(String.format("%s의 내용을 수정합니다\n입력 : ", postList.get(Integer.parseInt(stInput) - 1).GetTitle()));
		scan = new Scanner(System.in);
		shortInput = scan.next();
		postList.get(Integer.parseInt(stInput) - 1).SetContent(shortInput);
		System.out.println(String.format("%s 수정 완료", postList.get(Integer.parseInt(stInput) - 1).GetTitle()));
		return;
	}

	private Board() {

	}

	static Board getInstance() {
		return singleton;
	}
}
