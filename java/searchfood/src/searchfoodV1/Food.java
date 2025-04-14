package searchfoodV1;

public class Food {
	String stName;
	int nPrice;
	boolean isHot;

	public void Info() {
		System.out.println(String.format("이름 : %s\n가격 : %d원\n뜨거운 음식 : %b\n", this.stName, this.nPrice, this.isHot));
	}

	public Food(String stName, int nPrice, boolean isHot) {
		super();
		this.stName = stName;
		this.nPrice = nPrice;
		this.isHot = isHot;
	}

}
