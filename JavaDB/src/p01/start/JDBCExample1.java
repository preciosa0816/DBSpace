package p01.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample1 {

	public static void main(String[] args) {
		// oracle driver : 64bit-ojdbc6_g.jar
		// 32bit - ojdbc6.jar

		Connection conn = null;
		try {// 드라이버를 찾는 클래스
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(url, "madang", "madang");
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}
		System.out.println("Done.");
	}

}
