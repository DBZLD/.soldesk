package db;

import java.sql.ResultSet;

public class DbAccounts {
	static public String aPosition;
	static public String aId;

	static public boolean DbSignIn(String id, String pw) {
		boolean bReturn = false;
		try {
			aPosition = "";
			DbMain.result = DbMain.stEmployee.executeQuery(
					String.format("select*from employee_account where e_id = '%s' and e_pw = '%s'", id, pw));
			if (DbMain.result.next()) {
				ResultSet nameResult = DbMain.stEmployee
						.executeQuery(String.format("select*from employee where e_name = '%s'", id));
				bReturn = true;
				aPosition = nameResult.getString("e_position");
				aId = nameResult.getString("e_name");
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
}
