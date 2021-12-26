package P07.db_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Oracle DB에 있는 저장프로시저를 이용한 삽입 기능
public class ProcedureTest {
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

	// 저장 프로시저를 사용하기 전에 DB입력
	public void insert() {
		connect();
		try {
			PreparedStatement ps = null;
		    String sql = "insert into member3 values('procedure3','12345','홍길동2',22,'강원도2','hong2@hong.com')";	
			ps=con.prepareStatement(sql);
			int count=ps.executeUpdate();
			if (count > 0) {
				System.out.println("Insert Success2");
			} else {
				System.out.println("Insert Fail2");
			}
		} catch (SQLException e) {
			
		}

	}

	public void select() {
		connect();
		ResultSet rs = null;
		PreparedStatement ps =null;
		try {
			String sql = "select * from member3";
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String id =rs.getString(1);
				String passwd =rs.getString(2);
				String name =rs.getString(3);
				int age =rs.getInt(4);
				String addr =rs.getString(5);
				String email =rs.getString(6);
				System.out.println(id+" / "+passwd+" / "+name+" / "+age+" / "+addr+" / "+email);
			}
			System.out.println();
		} catch (SQLException e) {

		}

	}

	// 저장 프로시저를 사용하여 DB입력(PL/SQL)
	public void insertMember() {
		CallableStatement cs = null; // PLSQL에서 사용

		try {
			connect();
			String sql = "{call user_insert(?,?,?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, "procedure");
			cs.setString(2, "1234");
			cs.setString(3, "홍길동");
			cs.setInt(4, 20);
			cs.setString(5, "강원도");
			cs.setString(6, "hong@hong.com");
			int count = cs.executeUpdate();
			if (count > 0) {
				System.out.println("Insert Success");
			} else {
				System.out.println("Insert Fail");
			}

		} catch (SQLException e) {

		}
		try {
			cs.close();
			con.close();
		} catch (SQLException e) {

		}

	}

	public static void main(String[] args) {
		ProcedureTest pt = new ProcedureTest();
		System.out.println("Stored Procedure를 사용 전의 데이터");
		pt.insert();
		pt.select();

		System.out.println("Stored Procedure를 사용한 데이터");
		pt.insertMember();
		pt.select();

	}

}
