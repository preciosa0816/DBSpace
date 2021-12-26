package p08.db_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallInoutProc {

//	Connection con;
//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	static {// static 초기화 블록(가장 먼저 수행될 것)
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
//		}
//	}

//	public void connect() {
//
//		try {
//			con = DriverManager.getConnection(url, "javaDB", "javadb");
//
//		} catch (SQLException e) {
//			System.out.println("입출력이 어렵습니다.");
//		}
//	}

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = DriverManager.getConnection(url, "javaDB", "javadb");

		String p1value = new String("c");
		String p2value = new String("v");
		String p3value = null;

		CallableStatement cs = null; // PLSQL에서 사용

		String sql = "{call javatest(?,?,?)}";
		cs = con.prepareCall(sql);
		//IN Parameter
		cs.setString(1, p1value);
		cs.setString(2, p2value);
		
		//OUT Parameter
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.registerOutParameter(3, Types.VARCHAR);
		
		cs.execute();		
		
		//수행결과 가져오기
		p2value = cs.getString(2);
		p3value = cs.getString(3);

	
		System.out.println("p2 :" + p2value);
		System.out.println("p3 :" + p3value);

		cs.close();
		con.close();

	}
}
