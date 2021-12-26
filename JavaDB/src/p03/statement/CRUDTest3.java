package p03.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//PreparedStatement Interface
public class CRUDTest3 {
//1
	PreparedStatement pstmt = null;
	static Connection conn = null;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static {// static 초기화 블록(가장 먼저 수행될 것)

		try {
			//Connection conn = null;
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, "javaDB", "javadb");

			System.out.println("Connection Success!");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}
	}

//2


	public void insert() {
//member table에 'java', '3333' , '인공지능' ,20, '서울시2', 'java@java.com'
		try {
			String sql = "Insert into member values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "aaa");
			pstmt.setString(2, "3333");
			pstmt.setString(3, "인공지능");
			pstmt.setInt(4, 20);
			pstmt.setString(5, "서울시");
			pstmt.setString(6, "java@java.com");

			// int count = stmt.executeUpdate(sql); //Statement
			int count = pstmt.executeUpdate(); // Prepared Statement
			System.out.println("count : " + count);

			if (count > 0)
				System.out.println("입력 완료");
			else
				System.out.println("입력 실패");

		} catch (SQLException e) {
			System.out.println("입력 실패");
		}
		try {
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {

		}

	}

	public void select() {
// select * from member	
		ResultSet rs = null;
		try {
			String str = "select * from member";
			pstmt = conn.prepareStatement(str);
			// rs=pstmt.executeQuery(srt);
			rs = pstmt.executeQuery(); // 결과를 나타냄

			while (rs.next()) {
				String id = rs.getString("id");
				String passwd = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String addr = rs.getString(5);
				String email = rs.getString(6);
				System.out.println("아이디: " + id + ", 비밀번호 : " + passwd + ", 이름: " + name + ", 나이 : " + age + ", 주소 : "
						+ addr + ", 이메일: " + email);
			}
		} catch (SQLException e) {

		}
		try {
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {

		}

	}

	public void update() {
// id='aaa'찾아서 addr='춘천시'로 변경하기

		try {
			String sql = "Update member set addr=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "강릉시");
			pstmt.setString(2, "aaa");

			int count = pstmt.executeUpdate();
			System.out.println("count : " + count);
			if (count > 0)
				System.out.println("수정 완료");
			else
				System.out.println("수정 실패");

		} catch (SQLException e) {
			System.out.println("수정 실패");
		}
		try {
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {

		}

	}

	public void delete() {
//id = 'aaa'를 찾아서 행 삭제하기 

		try {
			String sql = "Delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "aaa");

			int count = pstmt.executeUpdate();
			System.out.println("count : " + count);
			if (count > 0)
				System.out.println("삭제 완료");
			else
				System.out.println("삭제실패");

		} catch (SQLException e) {
			System.out.println("삭제 실패");
		}
		try {
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {

		}
	}

	public static void main(String[] args) { // 수행 전 commit 확인하기!
		CRUDTest3 p = new CRUDTest3();
		System.out.println("====기존 테이블====");
	//	p.connect();// 기존수행
		p.select();

	//	p.connect();
		p.insert();
		System.out.println("====insert 수행 후====");

	//	p.connect();
		p.select();

	//	p.connect();
		p.update();
		System.out.println("====update 수행 후====");

		//p.connect();
		p.select();

	//	p.connect();
		p.delete();
		System.out.println("====delete 수행 후====");

		//p.connect();
		p.select();

	}

}
