package board; // 패키지 이름 선언 (현재 클래스는 board 패키지에 속함)

import java.sql.Connection; // 데이터베이스 연결을 위한 Connection 클래스
import java.sql.DriverManager; // 데이터베이스 연결을 생성하기 위한 DriverManager 클래스
import java.sql.ResultSet; // SQL 쿼리 결과를 처리하기 위한 ResultSet 클래스
import java.sql.SQLException; // SQL 작업 중 발생하는 예외를 처리하기 위한 SQLException 클래스
import java.sql.Statement; // SQL 쿼리를 실행하기 위한 Statement 클래스

public class Test { // Test 클래스 선언
	public static void main(String[] args) { // 프로그램 실행의 시작점
		initDb(); // 데이터베이스 드라이버를 초기화
		dbRun(); // 데이터베이스 작업 수행
	}

	static private void initDb() { // 데이터베이스 드라이버 초기화 메서드
		try {
			// MySQL JDBC 드라이버를 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버가 잘 연결되었습니다."); // 드라이버 로드 성공 시 메시지 출력
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 드라이버 로드 실패 시 예외를 출력
		}
	}

	static private void dbRun() { // 데이터베이스 작업을 수행하는 메서드
		Connection con = null; // 데이터베이스 연결 객체
		Statement st = null; // SQL 쿼리 실행 객체
		ResultSet result = null; // 쿼리 결과를 저장하는 객체

		try {
			// 데이터베이스에 연결 (URL, 사용자 이름, 비밀번호 제공)
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			// Statement 객체 생성 (쿼리 실행 준비)
			st = con.createStatement();

			// 첫 번째 쿼리 실행: p_number가 10인 데이터를 조회
			result = st.executeQuery("SELECT * FROM tottenham_squad WHERE p_number = 10");
			while (result.next()) { // 결과 행이 있을 때까지 반복
				String name = result.getString("p_name"); // p_name 필드의 값을 가져옴
				System.out.println("p_number=10: " + name); // 결과를 출력
			}

			st.executeUpdate("update tottenham_squad set p_number = 15 where p_number = 10"); // p_number가 10인 데이터의
																								// p_number를 15로 변경
			result.close(); // RestulSet 객체 닫기
			result = st.executeQuery("select*from tottenham_squad where p_number = 15");
			while (result.next()) { // 결과 행이 있을 때까지 반복
				String name = result.getString("p_name"); // p_name 필드의 값을 가져옴
				System.out.println("p_number=15: " + name); // 결과를 출력
			}

			result.close(); // RestulSet 객체 닫기
			// 두 번째 쿼리 실행: p_number가 4인 데이터를 조회
			result = st.executeQuery("SELECT * FROM tottenham_squad WHERE p_number = 4");
			while (result.next()) { // 결과 행이 있을 때까지 반복
				String name = result.getString("p_name"); // p_name 필드의 값을 가져옴
				System.out.println("p_number=4: " + name); // 결과를 출력
			}
		} catch (SQLException e) {
			// SQL 예외 발생 시 상세한 오류 정보 출력
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		} finally {
			// 데이터베이스 리소스 정리 (ResultSet, Statement, Connection을 닫음)
			try {
				if (result != null)
					result.close(); // ResultSet 객체 닫기
				if (st != null)
					st.close(); // Statement 객체 닫기
				if (con != null)
					con.close(); // Connection 객체 닫기
			} catch (SQLException e) {
				e.printStackTrace(); // 리소스 정리 중 발생한 예외 출력
			}
		}
	}
}
