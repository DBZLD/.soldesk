package extend2;

public class Object {
	String stName;

	void Info() {
		System.out.println("이름 : " + this.stName);
	}

	int ReturnClass() {
		return 1;
	}

	void FunctionObject() {
		System.out.println("FunctionObject");
	}

	Object(String name) {
		this.stName = name;
	}

	Object() {
		stName = "무명";
	}
}
