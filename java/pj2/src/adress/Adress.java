package adress;

import java.util.ArrayList;

public class Adress {
	String floor1;
	String floor2;

	public static void main(String[] args) {
		Adress adress1 = new Adress(); // 1번.힙구(강남구)에 A빌라(원래는 이름이 없음)(객체)을 생성
										// 2번.스택구에 Adress의 주소값을 담을 수 있는 adress1(변수)(값은 힙구 A빌딩)를 생성
										// 3번. adress1에 A빌라의 주소값을 대입(참조)
										// 2.(Adress adress1) 3.(=) 1.(new Adress();)

		adress1.floor1 = "김씨"; // 이 식은 adress1의 floor1 값을 바꾸는 것이 아닌 adress1이 가리키는 A빌라의 floor1을 김씨로 설정하는것임

		adress1.floor2 = "박씨"; // 위와 같음

		Adress adress2; // 똑같이 주소를 가리키는 adress2(현재 값은 null)

//		System.out.println(adress2.floor1); // 값이 null이기 때문에 오류 발생(건물을 찾아가야하지만 주소가 써있지 않음)

		adress2 = adress1; // adress2에 adress1의 값을 대입 adress2의 값이 힙구 A빌라의 주소가 되었음

		adress2.floor1 = "이씨"; // adress2가 가리키는 주소(힙구 A빌라)의 floor1의 값을 이씨로 바꿈
								// 동일 객체를 참조하는 동안은 adress2.floor1의 값을 adress1.floor1에게 영향을 끼치지 않을 수 없음

		Adress adress3 = new Adress(); // 새로운 B빌딩(floor1과 floor2의 값은 공실)을 힙구에 지은 다음 adress3가 그 주소를 가리킴

		adress3.floor1 = "최씨"; // 위의 adress1.floor1 설명과 같음

		adress3.floor2 = "장씨"; // 위와 같음

		// 만약 adress1과 adress2가 A빌라를 가리키고 있는 것이 아닌 각각의 값을 가지고 있다면 밑의 출력의 값이 다를것
		// ('adress1.floor1 = 김씨', 'adress2.floor2 = 이씨'을 위에서 실행했기 때문)
		System.out.println("1.");// 1번 실행문
		System.out.println("adress1.floor1 : " + adress1.floor1); // 실행시 adress1, adress2 둘다 이씨가 출력
		System.out.println("adress2.floor1 : " + adress2.floor1);
		System.out.println("adress3.floor1 : " + adress3.floor1); // adress3는 가리키는 주소가 다르기 때문에 최씨가 출력
		System.out.println("adress1.floor2 : " + adress1.floor2); // 이도 마찬가지로 위에선 adress2.twoFloor의 값은 따로 설정한 적이 없지만
		System.out.println("adress2.floor2 : " + adress2.floor2); // adress2.twoFloor의 값도 박씨로 출력
		System.out.println("adress3.floor2 : " + adress3.floor2); // adress3는 가리키는 주소가 다르기 때문에 장씨가 출력

		ArrayList<Adress> adress4 = new ArrayList<Adress>(); // 이번에는 C아파트 단지(객체)의 위치를 가리키는 adress4(변수)를 생성

		adress4.add(new Adress(adress1.floor1, adress1.floor2)); // adress4[0]의 값에 새로 만든 C아파트 1동의 주소값을 대입
																	// C아파트 1동의 floor1, floor2값은 adress1이 가리키는(A빌라)의
																	// 값(주소값 아님)을 넣은 것임

		adress4.add(new Adress("권씨")); // adress4[1]의 값에 새로 만든 C아파트 2동(floor1의 값은 권씨 floor2의 값은 공실)의 주소값을 대입
		adress4.add(adress4.get(1)); // adress4[2]의 값에 C아파트 2동의 주소값을 대입
		adress4.add(adress1); // adress4[3]의 값에 adress1의 주소값을 대입

		System.out.println("\n\n2.");// 2번 실행문
		for (int i = 0; i < adress4.size(); i++) {
			System.out.println(String.format("adress4[%d].floor1 = %s", i, adress4.get(i).floor1));// C아파트 모든 동을
			System.out.println(String.format("adress4[%d].floor2 = %s", i, adress4.get(i).floor2));// 돌아다니며 각 층의 정보 출력
			System.out.println();
		}
		adress1.floor2 = "윤씨"; // adress1이 가리키는(A빌라)의 floor2값을 윤씨로 바꿈

		System.out.println("\n\n3.");// 3번 실행문
		System.out.println("adress4[0].floor1 : " + adress4.get(0).floor1);// floor1의 값은 같음
		System.out.println("adress4[0].floor2 : " + adress4.get(0).floor2);// 'adress1.floor2 = "윤씨"'가 반영되지 않음
		System.out.println("adress4[3].floor1 : " + adress4.get(3).floor1);// floor1의 값은 같음
		System.out.println("adress4[3].floor2 : " + adress4.get(3).floor2);// 'adress1.floor2 = "윤씨"'가 반영됨
		System.out.println("\n\n4."); // 4번 실행문
		System.out.println("adress1의 값 : " + System.identityHashCode(adress1)); // 각 변수들이 가리키는 주소값
		System.out.println("adress2의 값 : " + System.identityHashCode(adress2));
		System.out.println("adress3의 값 : " + System.identityHashCode(adress3));
		System.out.println("adress4[0]의 값 : " + System.identityHashCode(adress4.get(0)));
		System.out.println("adress4[1]의 값 : " + System.identityHashCode(adress4.get(1)));
		System.out.println("adress4[2]의 값 : " + System.identityHashCode(adress4.get(2)));
		System.out.println("adress4[3]의 값 : " + System.identityHashCode(adress4.get(3)));

		String str1 = "서울대"; // 서울대를 지은 후 변수 str1에(스택영역) 주소값(힙구 문자열동 서울대)을 넣음 (문자열들은 힙 영역의 문자열 상수 풀에 저장됨)
		String str2 = "서울대"; // 변수 str2에 서울대의 주소값을 넣음 (위에 있는 str1이 가리키는 주소값의 서울대와 같은 서울대임)
		String str3 = "서울대"; // 변수 str3에 서울대의 주소값을 넣음 (위에 있는 str1,str2가 가리키는 주소값의 서울대와 같은 서울대임)
		String str4 = new String("서울대"); // 이 서울대는 위에 있는 서울대와 주소값이 다른 서울대임
		str1 += "분캠"; // 이 서울대는 위에 있는 서울대의 값을 바꾼 것이 아닌 서울대분캠이라는 건물을 새로 지은것임

		System.out.println("\n\n\nString"); // String 출력
		System.out.println("str1 : " + str1); // 서울대분캠 출력
		System.out.println("str2 : " + str2); // 서울대 출력
		System.out.println("str3 : " + str3); // 서울대 출력
		System.out.println("str4 : " + str4); // 서울대 출력(위의 서울대와 주소값이 다름)

		System.out.println("str1이 가리키는 주소값 : " + System.identityHashCode(str1)); // (str2의 서울대와 주소값이 다름)
		System.out.println("str2이 가리키는 주소값 : " + System.identityHashCode(str2)); // (str3의 서울대와 주소값이 같음)
		System.out.println("str3이 가리키는 주소값 : " + System.identityHashCode(str3)); // (str2의 서울대와 주소값이 같음)
		System.out.println("str3이 가리키는 주소값 : " + System.identityHashCode(str4)); // (str2의 서울대와 주소값이 다름)

		int i1 = 127; // i1에 127을 넣은것임 (힙 영역에 있는 객체의 주소값을 넣은 것이 아닌 값 자체를 스택 영역에 저장)
		Integer i2 = 127;
		int i3 = 127;// 위와 같음
		Integer i4 = 126;
		Integer i5 = 128;
		Integer i6 = 128;

		Integer i7 = new Integer(127); // 새로운 Integer클래스를 만든 뒤 그 주소값을 참조
		Integer i8 = new Integer(127); // 또 새로운 Integer클래스를 만든 뒤 그 주소값을 참조

		System.out.println("int i1 : " + System.identityHashCode(i1));// 이론상으로는 컴파일 오류(identityHashCode는 객체의 해시코드를 반환)가
																		// 나와야 하지만 오토박싱(Integer.valueOf(i1)로 변환)된 객체로
																		// 처리했음

		System.out.println("Integer i2 : " + System.identityHashCode(i2)); // Integer형 변수는 생성 시 오토 박싱이 되기에 원래 컴파일 오류가 나지
																			// 않음

		System.out.println("int i3 : " + System.identityHashCode(i3)); // 세 값이 같은 이유는 127이 캐싱된 범위에 들어있기 때문(-128 ~127에
																		// 속하는 경우 이미 캐싱된 객체를 반환하기 때문에 세 코드 모두 같은 캐싱된
																		// 127객체의 주소값이 출력)

		System.out.println("Integer i4 : " + System.identityHashCode(i4)); // 캐싱 범위 내여도 값이 다르면 다른 객체를 참조함

		System.out.println("Integer i5 : " + System.identityHashCode(i5)); // 캐싱된 범위에 들어있지 않기 때문에 동일한 값이라도 새로운 객체를 생성 후
		System.out.println("Integer i6 : " + System.identityHashCode(i6)); // 참조했기 때문에 반환 되는 주소값이 다름

		System.out.println("Integer i7 : " + System.identityHashCode(i7)); // 서로 다른 Integer클래스의 주소값을 참조했기 때문에 출력값이 다름
		System.out.println("Integer i8 : " + System.identityHashCode(i8)); // 위 모든 변수의 주소값(스택 영역)은 다름
	}

	Adress(String one, String two) {
		this.floor1 = one;
		this.floor2 = two;
	}

	Adress(String one) {
		this.floor1 = one;
		this.floor2 = "공실";
	}

	Adress() {
		this.floor1 = "공실";
		this.floor2 = "공실";
	}
}
