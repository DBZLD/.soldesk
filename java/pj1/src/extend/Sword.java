package extend;

public class Sword extends Item {
	int nDamage;

	void Info() {
		System.out.println(String.format("이름 : %s\n가격 : %d\n데미지 : %d", stName, nPrice, nDamage));
	}
}
