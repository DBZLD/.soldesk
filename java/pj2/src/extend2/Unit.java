package extend2;

public class Unit extends Object {
	int nUnit;

	void Info() {
		System.out.println("이름 : " + this.stName + "\n유닛 : " + nUnit);
	}

	int ReturnClass() {
		return 2;
	}

	void FunctionUnit() {
		System.out.println("FunctionUnit");
	}

	Unit(String name, int unit) {
		super(name);
		nUnit = unit;
	}

	Unit(int unit) {
		nUnit = unit;
	}
}
