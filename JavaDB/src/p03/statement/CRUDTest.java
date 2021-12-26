package p03.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Statement Interface
public class CRUDTest {
//1
	Connection conn = null;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static {// static 초기화 블록(가장 먼저 수행될 것)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		}
	}

//2
	public void connect() {

		try {
			conn = DriverManager.getConnection(url, "javaDB", "javadb");
			System.out.println("Connection Success!");

		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}

	}

	public void insert() {
//member table에 'aaa', '1111' , '22' , '서울시', 'a@a.com'
		// Insert into member values('aaa','aaa','홍길동',22,'서울시','a@a.com');
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			String sql = "Insert into member values('aaa','aaa','홍길동',22,'서울시','a@a.com')";
			int count = stmt.executeUpdate(sql); //업데이트 사항 수
			System.out.println("count : "+count);
			
			if (count > 0)
				System.out.println("입력 완료");
			else
				System.out.println("입력 실패");

		} catch (SQLException e) {
			System.out.println("입력 실패");
		}
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {

		}

	}

	public void select() {
// select * from member
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String str = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(str); //결과를 나타냄

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
			stmt.close();
			conn.close();
		} catch (SQLException e) {

		}

	}

	public void update() {
// id='aaa'찾아서 addr='부산시'로 변경하기
		
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			String sql = "Update member set addr='부산시' where id='aaa'";
			int count = stmt.executeUpdate(sql);
			System.out.println("count : "+count);
			if (count > 0)
				System.out.println("수정 완료");
			else
				System.out.println("수정 실패");

		} catch (SQLException e) {
			System.out.println("수정 실패");
		}
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {

		}
		
	}

	public void delete() {
//id = 'aaa'를 찾아서 행 삭제하기 
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			String sql = "Delete from member where id='aaa'";
			int count = stmt.executeUpdate(sql);
			System.out.println("count : "+count);
			if (count > 0)
				System.out.println("삭제 완료");
			else
				System.out.println("삭제실패");

		} catch (SQLException e) {
			System.out.println("삭제 실패");
		}
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {

		}
	}

	public static void main(String[] args) { // 수행 전 commit 확인하기!
		CRUDTest p = new CRUDTest();
		System.out.println("====기존 테이블====");
		p.connect();//기존수행
		p.select();

		p.connect();
		p.insert();
		System.out.println("====insert 수행 후====");

		p.connect();
		p.select();
		
		p.connect();
		p.update();
		System.out.println("====update 수행 후====");
		
		p.connect();
		p.select();
		
		p.connect();
		p.delete();
		System.out.println("====delete 수행 후====");
		
		p.connect();
		p.select();
		
	}

}
