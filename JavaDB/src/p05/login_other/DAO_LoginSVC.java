package p05.login_other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_LoginSVC {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	private String ip = "localhost";
	private String port = "1521";
	private String sid = "orcl";

	private String tableid = "javaDB";
	private String tablepassword = "javadb";
	private String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;

	private String table = "MEMBER2";

	ArrayList<DTO_User> idList = new ArrayList<DTO_User>();

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.(0)");
		}
	}

//	DB data connect
	public ArrayList<DTO_User> connect() {
		try {
			con = DriverManager.getConnection(url, tableid, tablepassword);

			String query = "SELECT * FROM " + table;
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				idList.add(new DTO_User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(1)");
		}
		return idList;
	}

//	1. 로그인
	public DTO_User loginCheck(String id, String password) {		
		for (DTO_User u : idList) {
			if (u.getId().equals(id) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

//	2. PASSWORDUPDATE
	public void passwordUpdate(String id, String password, String changePassword) {
		for (DTO_User u : idList) {
			if (u.getId().equals(id) && u.getPassword().equals(password)) {
				try {
					String query = "UPDATE " + table + " SET PASSWD = ? WHERE ID = ?";
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, changePassword);
					pstmt.setString(2, id);

					int count = pstmt.executeUpdate();
					if (count > 0) {
						System.out.println(id + "의 비밀번호 변경 완료");
					} else {
						System.out.println("UPDATE 실패");
					}
				} catch (SQLException e) {
					System.out.println("입출력이 어렵습니다.(2)");
				} finally {
					idList = new ArrayList<DTO_User>();
					connect();
				}
			}
		}
	}

//	3. IDINSERT
	public void idInsert(String id, String password, String name, int age, String address, String email) {
		try {
			String query = "INSERT INTO " + table + " VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setInt(4, age);
			pstmt.setString(5, address);
			pstmt.setString(6, email);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("아이디(" + id + ") 생성 완료");
			} else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			System.out.print("입출력이 어렵습니다.(4)");
			System.out.println(" : 기본키 중복검토 등 필요");
		} finally {
			idList = new ArrayList<DTO_User>();
			connect();
		}
	}

//	4. IDSELECT
	public void idSelect(String name, String email) {
		try {
			String query = "SELECT ID FROM " + table + " WHERE NAME = '" + name + "' and EMAIL = '" + email + "'";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("아이디 검색 결과 : " + rs.getString(1));
			} else {
				System.out.println("아이디 검색 실패");
			}
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(4)");
		}
	}

//	5. PASSWORDSELECT
	public void passwordSelect(String id, String name, String email) {
		try {
			String query = "SELECT PASSWD FROM " + table + " WHERE ID = '" + id + "' and NAME = '" + name
					+ "' and EMAIL = '" + email + "'";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("비밀번호 검색 결과 : " + rs.getString(1));
			} else {
				System.out.println("비밀번호 검색 실패");
			}
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(4)");
		}
	}

//	close method
	public void done() {
		try {
			rs.close();
			pstmt.close();
			System.out.println("\n[접속 종료]");
		} catch (SQLException e) {
		}
	}
}
