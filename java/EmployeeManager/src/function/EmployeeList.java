package function;

import db.DbMain;
import display.Display;

public class EmployeeList {
	static public void EList() {
		Display.Line();
		System.out.println("직원 리스트");
		Display.Line();
		DbMain.DbListEmployee();
	}
}
