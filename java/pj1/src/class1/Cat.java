package class1;

public class Cat {
	int nAge;
	int nWeight;
	String stName;
	
	public void Info() {
		System.out.println("이름 " + stName + " 나이 : " + nAge + " 몸무게 : " + nWeight);
	}
	public Cat() {
		
	}
	public Cat(String stName, int nAge, int nWeight) {
		this.stName = stName;
		this.nAge = nAge;
		this.nWeight = nWeight;
	}
	public Cat(String stName, int nAge) {
		this.stName = stName;
		this.nAge = nAge;
	}
}
