package extend2;

public class Human extends Unit {
	int nHuman;

	void Info() {
		System.out.println("이름 : " + this.stName + "\n유닛 : " + nUnit + "\n인간 : " + nHuman);
	}

	int ReturnClass() {
		return 3;
	}

	void FunctionHuman() {
		System.out.println("FunctionHuman");
	}

	Human(String name, int unit, int human) {
		super(name, unit);
		nHuman = human;
	}
}
