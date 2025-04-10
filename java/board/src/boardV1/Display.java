package boardV1;

public class Display {

	static void TitleDisplay() {
		System.out.println("1.글쓰기\n2.글리스트\n3.나가기\n입력 : ");
	}

	static void WriteMenu1Display() {
		System.out.println("\n글쓰기\n내용을 입력해주세요. : ");
	}

	static void PostListDisplay() {
		System.out.println();
		for (int i = 0; i < Function.postList.size(); i++) {
			System.out.println((i + 1) + "번\n" + Function.postList.get(i).stContent + "\n");
		}
	}
}
