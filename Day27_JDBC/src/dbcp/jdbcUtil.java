package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// mariadb-java-client-2.4.4.jar 라이브러리 넣어놔서 작업함
// 없으면 build path 하기

public class jdbcUtil {

	 public static Connection getConnection() {
		String protocol = "jdbc:mariadb://"; // 프로토콜
		String ip = "127.0.0.1";
		String port = "3306";
		String db = "saram";
		String url = String.format("%s%s:%s/%s", protocol, ip, port, db);
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // 외부에서 소스나 파일을 불러오면 예외가 발생할수있어서 try-catch문 쓰기
			return DriverManager.getConnection(url, user, password); // SQLException 발생하므로 try-catch 사용하기
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found ...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL exception ..."); // 해당 계정이 없으면 오류가 발생한다 (db, user, password 확인하기)
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of close
	}

}
