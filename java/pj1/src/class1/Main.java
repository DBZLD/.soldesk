package class1;

public class Main {
public static void main(String[] args) {
	Cat cat1 = new Cat();
	Cat cat2 = new Cat("xx", 5, 4);
	Cat cat3 = new Cat("yy", 2);
	cat1.stName = "zz";
	
	cat1.Info();
	cat2.Info();
	cat3.Info();
}
}
