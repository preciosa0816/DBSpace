package p06.mvc_other;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAO_Oracle implements DAO {

	private String table = "PRODUCT";

	private PreparedStatement pstmt;
	private ResultSet rs;

	DB_Connect c = new DB_Connect();
	Vector<DTO_Product> productsVector;

	@Override
	public void insert(DTO_Product p) {
//		Query 생성
		String name = p.getName();
		int price = p.getPrice();
		String query = "INSERT INTO " + table + " VALUES(PRODUCT_NUM_SEQ.NEXTVAL, '" + name + "', " + price + ")";

		try {
//			Query 실행
			pstmt = c.on().prepareStatement(query);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(2.1)");
		}
	}

	@Override
	public DTO_Product select(int num) {
//		DTO_Product 초기화, Query 생성
		DTO_Product p = null;
		String query = "SELECT * FROM " + table + " WHERE NUM = " + num;

		try {
//			Query 실행
			pstmt = c.on().prepareStatement(query);
			rs = pstmt.executeQuery();
//			DTO_Product에 출력내용 저장
			if (rs.next()) {
				p = new DTO_Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(2.2)");
		}
//		결과(DTO_Product) 반환
		return p;
	}

	@Override
	public Vector<DTO_Product> selectAll() {
//		Vector 초기화, Query 생성
		productsVector = new Vector<DTO_Product>();
		String query = "SELECT * FROM " + table;

		try {
//			Query 실행
			pstmt = c.on().prepareStatement(query);
			rs = pstmt.executeQuery();
//			Vector에 출력내용 저장
			while (rs.next()) {
				productsVector.add(new DTO_Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(2.3)");
		}
//		결과(Vector) 반환
		return productsVector;
	}

	@Override
	public void delete(int num) {
//		Query 생성
		String query = "DELETE FROM " + table + " WHERE NUM = " + num;
		try {
//			Query 실행
			pstmt = c.on().prepareStatement(query);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(2.4)");
		}
	}

	@Override
	public void update(int num, DTO_Product p) {
//		Query 생성
		String query = "UPDATE " + table + " SET NAME = '" + p.getName() + "', PRICE = " + p.getPrice()
				+ " WHERE NUM = " + num;
		try {
//			Query 실행
			pstmt = c.on().prepareStatement(query);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.(2.5)");
		}
	}

	public void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			c.close();
		} catch (SQLException e) {
		}
	}

}
