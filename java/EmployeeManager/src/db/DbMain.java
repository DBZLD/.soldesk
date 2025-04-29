package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

import display.Display;

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

	static public boolean DbDeleteEmployee(String name) {
		boolean bReturn = false;
		try {
			String query = String.format("delete from employee where e_name = '%s'", name);
			int nChange = stEmployee.executeUpdate(query);
			if (nChange > 0) {
				stEmployee.executeUpdate(String.format("delete from employee_account where e_name = '%s'", name));
				bReturn = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}

	static public void DbNameListEmployee() {
		try {
			result = stEmployee.executeQuery("select*from employee");
			Display.Line();
			while (result.next()) {
				System.out.println(String.format("%s %s", result.getString("e_name"), result.getString("e_position")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbListEmployee() {
		try {
			result = stEmployee.executeQuery("select*from employee");
			Display.Line();
			while (result.next()) {
				DecimalFormat df = new DecimalFormat("#,###");
				int nIncome = Integer.parseInt(result.getString("e_annual_income"));
				System.out.println(String.format("%s %s | 나이 %s세(%s) | 입사일 %s | 연봉 %s원", result.getString("e_name"),
						result.getString("e_position"), result.getString("e_age"), result.getString("e_gender"),
						result.getString("e_join_date"), df.format(nIncome)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void DbInsertEmployee(String name, String position, String age, String income, String gender) {
		try {
			stEmployee.executeUpdate(String.format(
					"insert into employee(e_name, e_position, e_age, e_annual_income, e_gender, e_join_date) value('%s', '%s', %s, %s, '%s', now())",
					name, position, age, income, gender));
			Display.Line();
			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
