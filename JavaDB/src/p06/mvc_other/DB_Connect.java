package p06.mvc_other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//	DB 연결 기능 수행
public class DB_Connect {
	private String ip = "localhost";
	private String port = "1521";
	private String sid = "orcl";
	private String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;

	private String dbid = "javaDB";
	private String dbpassword = "javadb";

	private Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
//			Class.forName() ERROR
			System.out.println("드라이버 로딩에 실패했습니다.(1.1)");
		}
	}

	public Connection on() {
		try {
			con = DriverManager.getConnection(url, dbid, dbpassword);
		} catch (SQLException e) {
//			Connection ERROR
			System.out.println("드라이버 로딩에 실패했습니다.(1.2)");
		}
		return con;
	}

	public void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
		}
	}
}
