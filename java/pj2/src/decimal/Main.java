package decimal;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat(",###");
		System.out.println(df.format(1000000));
	}
}