package p09.java_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Java_procedure {

	public static void main(String[] args)  {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			System.out.println(1);
		}

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, "Scott", "scott");
		} catch (SQLException e) {
			System.out.println(2);
		}

		
		CallableStatement cs = null; // PLSQL에서 사용

		String sql = "{call sel_empno(?,?,?,?)}";
		try {
			cs = con.prepareCall(sql);
		} catch (SQLException e) {
			System.out.println(3);
		}
		//IN Parameter
		try {
			cs.setInt(1, 7788);
		} catch (SQLException e) {
			System.out.println(4);
		}
		
		
		//OUT Parameter
		
		try {
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.VARCHAR);
		} catch (SQLException e) {
			System.out.println(5);
		}
		
		
		try {
			cs.execute();
		} catch (SQLException e) {
			System.out.println(6);
		}		
		
		//수행결과 가져오기
		String var_ename = null;
		int var_sal = 0 ;
		String var_job = null;
		
		try {
			var_ename = cs.getNString(2);
			var_sal=cs.getInt(3);
			var_job = cs.getString(4);
		} catch (SQLException e) {
			System.out.println(7);
		}
		
		System.out.println(var_ename +"의 연봉은 "+var_sal+"이고 직업은"+var_job+"이다.");
		

		
		try {
			cs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(8);
		}

	}
}
