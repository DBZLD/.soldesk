package adress;

import java.util.ArrayList;

public class Adressgpt {
	String floor1; // 1층. 인스턴스 변수. 힙 메모리에 저장됨.
	String floor2; // 2층. 인스턴스 변수. 힙 메모리에 저장됨.

	public static void main(String[] args) {
		Adress adress1 = new Adress(); // 힙 영역에 새로운 Adress 객체(A빌라)를 생성하고, adress1 변수가 이를 참조.
		adress1.floor1 = "김씨"; // adress1(A빌라)이 가리키는 객체의 1층 값을 "김씨"로 설정.
		adress1.floor2 = "박씨"; // adress1(A빌라)이 가리키는 객체의 2층 값을 "박씨"로 설정.

		Adress adress2; // 스택 메모리에 adress2 변수를 생성. 초기값은 null.
		// System.out.println(adress2.floor1); // adress2가 null을 참조하므로
		// NullPointerException 발생.

		adress2 = adress1; // adress2가 adress1(A빌라)이 가리키는 객체를 참조하도록 설정.
		adress2.floor1 = "이씨"; // adress2(A빌라)와 adress1(A빌라)이 같은 객체를 참조하므로 1층 값이 "이씨"로 변경됨.

		Adress adress3 = new Adress(); // 힙 영역에 새로운 Adress 객체(B빌라)를 생성하고 adress3 변수가 이를 참조.
		adress3.floor1 = "최씨"; // adress3(B빌라)이 가리키는 객체의 1층 값을 "최씨"로 설정.
		adress3.floor2 = "장씨"; // adress3(B빌라)이 가리키는 객체의 2층 값을 "장씨"로 설정.

		System.out.println("1."); // 출력 실행
		System.out.println("adress1(A빌라)의 1층 : " + adress1.floor1); // adress1(A빌라)이 참조하는 객체의 1층 값 출력.
		System.out.println("adress2(B빌라)의 1층 : " + adress2.floor1); // adress2(A빌라)이 참조하는 객체의 1층 값 출력.
		System.out.println("adress3(C빌라)의 1층 : " + adress3.floor1); // adress3(B빌라)이 참조하는 객체의 1층 값 출력.
		System.out.println("adress1(A빌라)의 2층 : " + adress1.floor2); // adress1(A빌라)이 참조하는 객체의 2층 값 출력.
		System.out.println("adress2(B빌라)의 2층 : " + adress2.floor2); // adress2(A빌라)이 참조하는 객체의 2층 값 출력.
		System.out.println("adress3(C빌라)의 2층 : " + adress3.floor2); // adress3(B빌라)이 참조하는 객체의 2층 값 출력.

		ArrayList<Adress> adress4 = new ArrayList<>(); // 힙 영역에 ArrayList 객체(C아파트)를 생성. adress4가 이를 참조.
		adress4.add(new Adress(adress1.floor1, adress1.floor2)); // 새로운 Adress 객체(C아파트[0]동) 생성 후 추가.
		adress4.add(new Adress("권씨")); // 새로운 Adress 객체(C아파트[1]동) 생성 후 추가.
		adress4.add(adress4.get(1)); // C아파트[1]동을 참조하는 객체를 C아파트[2]동으로 추가.
		adress4.add(adress1); // adress1(A빌라)을 참조하는 객체를 C아파트[3]동으로 추가.

		System.out.println("\n\n2."); // 출력 실행
		for (int i = 0; i < adress4.size(); i++) {
			System.out.println(String.format("adress4[C아파트[%d]동].1층 = %s", i, adress4.get(i).floor1)); // 각 동의 1층 값 출력.
			System.out.println(String.format("adress4[C아파트[%d]동].2층 = %s", i, adress4.get(i).floor2)); // 각 동의 2층 값 출력.
			System.out.println();
		}

		adress1.floor2 = "윤씨"; // adress1(A빌라)이 참조하는 객체의 2층 값을 "윤씨"로 변경.

		System.out.println("\n\n3."); // 출력 실행
		System.out.println("adress4[C아파트[0]동].1층 : " + adress4.get(0).floor1); // C아파트[0]동의 1층 값 출력.
		System.out.println("adress4[C아파트[0]동].2층 : " + adress4.get(0).floor2); // C아파트[0]동의 2층 값 출력. (변경되지 않음)
		System.out.println("adress4[C아파트[3]동].1층 : " + adress4.get(3).floor1); // C아파트[3]동의 1층 값 출력.
		System.out.println("adress4[C아파트[3]동].2층 : " + adress4.get(3).floor2); // C아파트[3]동의 2층 값 출력. (변경됨)

		System.out.println("\n\n4."); // 출력 실행
		System.out.println("adress1(A빌라)의 값 : " + System.identityHashCode(adress1)); // adress1(A빌라)이 참조하는 객체의 해시코드 출력.
		System.out.println("adress2(B빌라)의 값 : " + System.identityHashCode(adress2)); // adress2(A빌라)이 참조하는 객체의 해시코드 출력.
		System.out.println("adress3(C빌라)의 값 : " + System.identityHashCode(adress3)); // adress3(B빌라)이 참조하는 객체의 해시코드 출력.
		System.out.println("adress4[C아파트[0]동]의 값 : " + System.identityHashCode(adress4.get(0))); // C아파트[0]동 객체의 해시코드 출력.
		System.out.println("adress4[C아파트[1]동]의 값 : " + System.identityHashCode(adress4.get(1))); // C아파트[1]동 객체의 해시코드 출력.
		System.out.println("adress4[C아파트[2]동]의 값 : " + System.identityHashCode(adress4.get(2))); // C아파트[2]동 객체의 해시코드 출력.
		System.out.println("adress4[C아파트[3]동]의 값 : " + System.identityHashCode(adress4.get(3))); // C아파트[3]동 객체의 해시코드 출력.

		String str1 = "서울대"; // 문자열 "서울대"를 생성하고 str1 변수에 참조 주소를 저장.
		String str2 = "서울대"; // 이미 생성된 "서울대"의 참조 주소를 str2 변수에 저장.
		String str3 = "서울대"; // 이미 생성된 "서울대"의 참조 주소를 str3 변수에 저장.
		String str4 = new String("서울대"); // 새로 "서울대" 문자열 객체를 생성하고 str4 변수에 참조 주소를 저장.
		str1 += "분캠"; // "서울대" 문자열에 "분캠"을 추가한 새 문자열을 생성하고 str1 변수에 참조 주소를 저장.

		System.out.println("\n\n\nString"); // 구분을 위해 "String" 출력.
		System.out.println("str1 : " + str1); // str1이 참조하는 "서울대분캠" 출력.
		System.out.println("str2 : " + str2); // str2가 참조하는 "서울대" 출력.
		System.out.println("str3 : " + str3); // str3가 참조하는 "서울대" 출력.
		System.out.println("str4 : " + str4); // str4가 참조하는 "서울대" 출력.

		System.out.println("str1이 가리키는 주소값 : " + System.identityHashCode(str1)); // str1이 참조하는 새 문자열의 주소 출력.
		System.out.println("str2이 가리키는 주소값 : " + System.identityHashCode(str2)); // str2가 참조하는 "서울대"의 주소 출력.
		System.out.println("str3이 가리키는 주소값 : " + System.identityHashCode(str3)); // str3가 참조하는 "서울대"의 주소 출력.
		System.out.println("str4이 가리키는 주소값 : " + System.identityHashCode(str4)); // str4가 참조하는 새 객체의 주소 출력.

		int i1 = 127; // i1에 정수 값 127을 저장.
		Integer i2 = 127; // 정수 127이 박싱되어 Integer 객체를 생성하고 i2에 참조 주소를 저장.
		int i3 = 127; // i3에 정수 값 127을 저장.
		Integer i4 = 128; // 정수 128이 박싱되어 새로운 Integer 객체를 생성하고 i4에 참조 주소를 저장.
		Integer i5 = 128; // 정수 128이 박싱되어 새로운 Integer 객체를 생성하고 i5에 참조 주소를 저장.

		Integer i6 = 1; // 정수 1이 박싱되어 Integer 객체를 생성하고 i6에 참조 주소를 저장.
		Integer i7 = 2; // 정수 2가 박싱되어 Integer 객체를 생성하고 i7에 참조 주소를 저장.

		System.out.println("int i1 : " + System.identityHashCode(i1)); // i1은 박싱되어 Integer 객체로 처리되며, 해당 객체의 주소 출력.
		System.out.println("Integer i2 : " + System.identityHashCode(i2)); // i2가 참조하는 Integer 객체의 주소 출력.
		System.out.println("int i3 : " + System.identityHashCode(i3)); // i3은 박싱되어 Integer 객체로 처리되며, 해당 객체의 주소 출력.

		System.out.println("Integer i4 : " + System.identityHashCode(i4)); // i4가 참조하는 Integer 객체의 주소 출력.
		System.out.println("Integer i5 : " + System.identityHashCode(i5)); // i5가 참조하는 Integer 객체의 주소 출력.

		System.out.println("Integer i6 : " + System.identityHashCode(i6)); // i6가 참조하는 Integer 객체의 주소 출력.
		System.out.println("Integer i7 : " + System.identityHashCode(i7)); // i7가 참조하는 Integer 객체의 주소 출력.
	}
}
