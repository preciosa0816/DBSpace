package p06.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//DB연결
public class DBConnect {
	
	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static {// static 초기화 블록(가장 먼저 수행될 것)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		}
	}

	public void connect() {

		try {
			con = DriverManager.getConnection(url, "javaDB", "javadb");
			
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}
	}

}
