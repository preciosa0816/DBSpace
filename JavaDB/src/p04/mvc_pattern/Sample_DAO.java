package p04.mvc_pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO(Data Access Object: DB접근 내용 작성)
public class Sample_DAO {

	public ArrayList<SampleDTO> findAll() {
		// DTO리스트 저장
		ArrayList<SampleDTO> as = new ArrayList<SampleDTO>();

		// JDBC드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		}

		// DB접속
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try (Connection conn = DriverManager.getConnection(url, "javaDB", "javadb");) {
			// select문 사용해서 DB에 있는 테이블 내용을 가져와서 ArrayList<>에 저장하기
			Statement stmt = conn.createStatement();
			String sql = "select * from book";
			stmt.execute(sql);
			ResultSet rs = null;
			rs = stmt.executeQuery(sql); // 결과를 나타냄

			while (rs.next()) {
				SampleDTO sd = new SampleDTO();//how1
				String id = rs.getString(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				sd.setId(id);//how1
				sd.setName(name);//how1
				sd.setPrice(price);//how1
				as.add(sd);//how1
				//as.add(new SampleDTO(id, name, price));//how2
			}

		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}

		return as;

	}

}
