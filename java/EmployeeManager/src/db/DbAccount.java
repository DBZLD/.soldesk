package db;

import java.sql.ResultSet;

public class DbAccount {
	static String aPosition = "";
	static String aId = "";

	static public boolean DbSignIn(String id, String pw) {
		boolean bReturn = false;
		try {
			DbMain.result = DbMain.stEmployee.executeQuery(
					String.format("select*from employee_account where e_id = '%s' and e_pw = '%s'", id, pw));
			if (DbMain.result.next()) {
				ResultSet nameResult = DbMain.stEmployee
						.executeQuery(String.format("select*from employee where e_name = '%s'", id));
				if (nameResult.next()) {
					aPosition = nameResult.getString("e_position");
					aId = nameResult.getString("e_name");
					bReturn = true;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return bReturn;
	}

	static public boolean DbSignUp(String id, String pw) {
		boolean bReturn = false;
		try {
			DbMain.result = DbMain.stEmployee
					.executeQuery(String.format("select*from employee where e_name = '%s'", id));
			if (DbMain.result.next()) {
				DbMain.stEmployee.executeUpdate(
						String.format("insert into employee_account(e_id, e_pw) value ('%s', '%s')", id, pw));
				bReturn = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return bReturn;
	}

	static public String GetId() {
		return aId;
	}

	static public String GetPosition() {
		return aPosition;
	}
}
