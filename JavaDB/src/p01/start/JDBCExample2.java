package p01.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {

	public static void main(String[] args) {
		// OracleDB(Madang)에 테이블 만들고 데이터 입력하기
		// 자바에서 오라클 DB에 접속해서 데이터 출력

		Connection conn = null;
		try {// 드라이버를 찾는 클래스
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(url, "madang", "madang");// 데이터베이스 연결

			String str = "select code, name, price, maker from Goodsinfo";//*써도됨
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			System.out.println("상품코드 상품명 \t\t 가격 제조사");
			System.out.println("-------------------------");
			while (rs.next()) {
				String code = rs.getString("code");//문자열 or column index
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString(4); //column은 1부터 시작 
				System.out.printf("%8s %s \t %12d %s%n", code, name, price, maker); //s:문자 n:줄바꿈
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}
		System.out.println("Done.");

		try {
			conn.close();
		} catch (SQLException e) {

		}

	}

}
