package p10.datatype_clob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobTest {
	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	StringBuffer sb = null;
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

	public void insert() {
		connect();
		PreparedStatement pstmt = null;
		// ResultSet rs=null;
		sb = new StringBuffer();
		String name = "홍길동";
		String sql = null;
		int count = 0;
		try {
			
			for (int i = 0; i <= 10000; i++) {				
				sb.append(name);
				 sql = "insert into clobtable values(1,?)";	
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sb.toString());
				count=pstmt.executeUpdate();
				}
			   
			if (count > 0) {
				System.out.println("Insert Success!");
			} else {
				System.out.println("Insert Fail");
			}
		} catch (SQLException e) {
			System.out.println(1);
		} 
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(3);
			}
		}
	}

	public void select() {
		connect();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from clobtable";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt(1);
				String content = rs.getString(2);
				System.out.println("번호 :  " + num + " , 내용 :  " + content);
			}
			System.out.println();
		} catch (SQLException e) {

		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		ClobTest ct = new ClobTest();
		ct.insert();
		ct.select();

	}

}
