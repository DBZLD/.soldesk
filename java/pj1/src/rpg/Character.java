package rpg;

public class Character {
	String stName;
	int nHp;
	int nDamage;
	int nGold;
	
	public void Info() {
		System.out.println("이름 : " + stName + " 최대 체력 : " + nHp + " 공격력 : " +
		nDamage + " 보유 골드 : " + nGold);
	}
	public Character(String stName, int nHp, int nDamage) {
		this.stName = stName;
		this.nHp = nHp;
		this.nDamage = nDamage;
	}
}
