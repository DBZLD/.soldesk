package db;

public class DbAccounts {
	static final String TABLE_NAME = "employee_account";
	static boolean isAdmin;

	static public boolean DbSignIn(String id, String pw) {
		try {
			isAdmin = false;
			DbMain.result = DbMain.stEmployee.executeQuery(
					String.format("select*from %s where e_id = '%s' and e_pw = '%s' limit 1", TABLE_NAME, id, pw));
			if (DbMain.result.next()) {
				DbMain.result.getBoolean("e_admin");
				return true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}
}
