package main;

import db.DbMain;
import function.FunctionMain;

public class Main {
	public static void main(String[] args) {
		FunctionMain fMain = FunctionMain.getInstance();
		DbMain.DbInit();
		fMain.Run();
	}
}
