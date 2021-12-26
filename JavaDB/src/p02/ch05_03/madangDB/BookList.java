package p02.ch05_03.madangDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//278P
public class BookList {
//Madang DB에서 Book 테이블에 있는 내용을 자바에 출력하기
	Connection con;
	public BookList() {
		//접속변수 초기화. url은 자바 드라이버 이름, DBMS -jdbc:oracle:thin:, 호스트명-localhost, 접속 포트번호-1521, 데이터베이스이름-orcl
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "madang";//관리자
		String pwd="madang";//사용자의 비밀번호
		
		
		try {/*드라이버를 찾는 과정*/
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 로딩후 드라이버 이름 입력
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("데이터베이스 연결 준비...");
			con=DriverManager.getConnection(url, userid, pwd);//접속객체 : con을 DriverManager.getConnection함수로 생성
			System.out.println("데이터베이스 연결 성공");//접속 성공시
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	private void sqlRun() {
		String query="SELECT * FROM Book";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("BOOK ID \tBOOK NAME \t PUBLISHER \tPRICE");
			
			while(rs.next()) {
				System.out.printf("\t"+rs.getInt(1));
				System.out.printf("\t"+rs.getString(2));
				System.out.printf("\t"+rs.getString(3));
				System.out.println("\t\t"+rs.getInt(4));
			}
			con.close(); //실행이 끝나면 접속 끊기
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		BookList so = new BookList();
		so.sqlRun();
		

	}

}
