package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DbMain {
	static public final String DB_ID = "root";
	static public final String DB_PW = "root";
	static public final String DB_NAME = "employee_manage";
	static Connection conEmployee = null;
	static Statement stEmployee = null;
	static ResultSet result = null;
	Scanner sc;
	String stInput;

	static public void DbInit() {
		try {
			conEmployee = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_ID, DB_PW);
			stEmployee = conEmployee.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
