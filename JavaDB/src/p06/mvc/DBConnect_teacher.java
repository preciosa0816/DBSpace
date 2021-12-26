package p06.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect_teacher {
	private static DBConnect db = new DBConnect();
	private Connection con = null;
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	//생성자
	private DBConnect_teacher() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection( jdbc_url, "javaDB", "javadb");

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		}catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}
	}
	//싱글톤
	public static DBConnect getInstance() {
		return db;
	}
	public Connection getConection() {
		return con;
	}
	
	
	
}
