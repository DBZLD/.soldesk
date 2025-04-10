package adress;

import java.util.ArrayList;

public class Adress {
	String oneFloor;
	String twoFloor;

	public static void main(String[] args) {
		Adress adress1 = new Adress(); // 1번.힙구(강남구)에 Adress1(원래는 이름이 없음)빌딩(객체)을 생성
										// 2번.스택구에 Adress형식의 adress1(변수)(값은 힙구 Adress1빌딩)를 생성
										// 3번. adress1에 Adress1빌딩의 주소를 저장(참조)
										// 2.(Adress adress1) 3.(=) 1.(new Adress();)

		adress1.oneFloor = "카페"; // 이 식은 adress1의 oneFloor 값을 바꾸는 것이 아닌 adress1이 가리키는 Adress1빌딩의 oneFloor를 카페으로
									// 설정하는것임

		adress1.twoFloor = "병원"; // 위와 같음

		Adress adress2; // 똑같이 주소를 가리키는 adress2(현재 값은 null)

//		System.out.println(adress2.nOneFloor); // 값이 null이기 때문에 오류 발생(건물을 찾아가야하지만 주소가 써있지 않음)

		adress2 = adress1; // adress2에 adress1의 값을 대입 adress2의 값이 힙구 Adress1빌딩의 주소가 되었음

		adress2.oneFloor = "빵집"; // adress2가 가리키는 주소(힙구 Adress1빌딩)의 nOneFloor의 값을 빵집으로 바꿈
									// 동일 객체를 참조하는 동안은 adress2.oneFloor의 값을 adress1.oneFloor에게 영향을 끼치지 않을 수 없음

		Adress adress3 = new Adress(); // 새로운 Adress2빌딩(oneFloor와 TwoFloor의 값은 null)을 힙구에 지은 다음 adress3가 주소를 가리킴

		adress3.oneFloor = "약국"; // 위의 adress1.oneFloor 설명과 같음

		adress3.twoFloor = "식당"; // 위와 같음

		// 만약 adress1과 adress2가 Adress1빌딩를 가리키고 있는 것이 아닌 각각의 값을 가지고 있다면 밑의 출력의 값이 다를것
		// ('adress1.oneFloor = 카페', 'adress2.oneFloor = 빵집'을 위에서 실행했기 때문)
		System.out.println("\n\n\n1.");// 1번 실행문
		System.out.println("adress1.oneFloor : " + adress1.oneFloor); // 실행시 adress1, adress2 둘다 빵집이 출력
		System.out.println("adress2.oneFloor : " + adress2.oneFloor);
		System.out.println("adress3.oneFloor : " + adress3.oneFloor); // adress3는 가리키는 주소가 다르기 때문에 약국이 출력
		System.out.println();
		System.out.println("adress1.twoFloor : " + adress1.twoFloor); // 이도 마찬가지로 위에선 adress2.twoFloor의 값은 따로 설정한 적이 없지만
		System.out.println("adress2.twoFloor : " + adress2.twoFloor); // adress2.twoFloor의 값도 안과로 출력
		System.out.println("adress3.twoFloor : " + adress3.twoFloor); // adress3는 가리키는 주소가 다르기 때문에 식당이 출력

		ArrayList<Adress> adress4 = new ArrayList<Adress>(); // 이번에는 Adress아파트 단지(객체)의 위치를 가리키는 adress4(변수)를 생성

		adress4.add(new Adress()); // adress4[0]의 값에 새로 만든 Adress아파트 1동(oneFloor,twoFloor 모두 null)의 주소값을 대입
		adress4.add(new Adress("도장")); // adress4[1]의 값에 새로 만든 Adress아파트 2동(oneFloor의 값은 도장)의 주소값을 대입
		adress4.add(adress4.get(1)); // adress4[2]의 값에 Adress아파트 2동의 주소값을 대입
		adress4.add(new Adress()); // adress4[3]의 값에 새로 만든 Adress아파트 3동(oneFloor,twoFloor 모두 null)의 주소값을 대입

		adress4.set(3, adress1); // adress4[3]의 값을 Adress1빌딩의 주소값으로 바꿈

		adress4.get(0).oneFloor = adress1.oneFloor;// adress4[0]이 가리키는 주소(Adress아파트 1동)의 twoFloor값에 Adress1빌딩의
													// oneFloor값을 넣음
		adress4.get(0).twoFloor = adress1.twoFloor;// adress4[0]이 가리키는 주소(Adress아파트 1동)의 oneFloor값에 Adress1빌딩의
													// twoFloor값을 넣음
		System.out.println("\n\n\n2.");// 2번 실행문
		for (int i = 0; i < adress4.size(); i++) {
			System.out.println(String.format("adress4[%d].oneFloor = %s", i, adress4.get(i).oneFloor));// Adress아파트 모든 동을
			System.out.println(); 																	// 돌아다니며 각 층의 정보 출력
		}
		adress1.twoFloor = "사무실"; // adress1이 가리키는(Adress1빌딩)의 twoFloor값을 사무실로 바꿈
		System.out.println("\n\n\n3.");// 3번 실행문
		System.out.println("adress4[0].oneFloor : " + adress4.get(0).oneFloor);// oneFloor의 값은 같음
		System.out.println("adress4[0].twoFloor : " + adress4.get(0).twoFloor);// 'adress1.twoFloor = "사무실"'이 반영되지 않음
		System.out.println();
		System.out.println("adress4[3].oneFloor : " + adress4.get(3).oneFloor);// oneFloor의 값은 같음
		System.out.println("adress4[3].twoFloor : " + adress4.get(3).twoFloor);// 'adress1.twoFloor = "사무실"'이 반영됨
	}

	Adress(String one, String two) {
		this.oneFloor = one;
		this.twoFloor = two;
	}

	Adress(String one) {
		this.oneFloor = one;
	}

	Adress() {

	}
}
