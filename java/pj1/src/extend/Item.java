package extend;

public class Item extends GameObject {
	int nPrice;

	void Info() {
		System.out.println(String.format("이름 : %s\n가격 : %d", stName, nPrice));
	}
}
