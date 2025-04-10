package boardV0;

public class Color {
	
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static final String EXIT = "\u001B[0m";
	
	static public String Red(String s) {	return RED+s+EXIT;		}
	static public String Green(String s) {	return GREEN+s+EXIT;		}
	static public String Yellow(String s) {	return YELLOW+s+EXIT;		}
	static public String Blue(String s) {	return BLUE+s+EXIT;		}
	static public String Purple(String s) {	return PURPLE+s+EXIT;		}
	static public String Cyan(String s) {	return CYAN+s+EXIT;		}
	static public String White(String s) {	return WHITE+s+EXIT;		}
	static public void TextRed(String s) {	System.out.println(RED+s+EXIT);		}
	static public void TextGreen(String s) {	System.out.println(GREEN+s+EXIT);		}
	static public void TextYellow(String s) {	System.out.println(YELLOW+s+EXIT);		}
	static public void TextBlue(String s) {	System.out.println(BLUE+s+EXIT);		}
	static public void TextPurple(String s) {	System.out.println(PURPLE+s+EXIT);		}
	static public void TextCyan(String s) {	System.out.println(CYAN+s+EXIT);		}
	static public void TextWhite(String s) {	System.out.println(WHITE+s+EXIT);		}
}
