package boardV5;

public class Display {

	static void TitleDisplay() {
		System.out.println("1.글 쓰기\n2.글 리스트\n3.글 삭제\n4.글 수정\n5.나가기\n입력 : ");
	}

	static void WriteMenu1Display() {
		System.out.println("\n글 쓰기\n내용을 입력해주세요. : ");
	}

	static void PostListDisplay() {
		System.out.println();
		for (int i = 0; i < Function.postList.size(); i++) {
			System.out.println((i + 1) + "번\n" + Function.postList.get(i).stContent + "\n");
		}
	}

	static void DeletePostListDisplay() {
		System.out.println("\n글 삭제(번호를 입력하여 삭제) e.나가기\n");
		for (int i = 0; i < Function.postList.size(); i++) {
			System.out.println((i + 1) + "번글 삭제");
		}
	}

	static void ResetPostListDisplay() {
		System.out.println("\n글 수정(번호를 입력하여 수정) e.나가기\n");
		for (int i = 0; i < Function.postList.size(); i++) {
			System.out.println((i + 1) + "번글 재입력");
		}
	}
}
