package p06.mvc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

//DAO : DB접근 해서 저장 데이터 가져오기
public class OracleDao implements Dao {
	Product p = new Product();
	DBConnect db = new DBConnect();
	Vector<Product> v = new Vector<Product>();
	HashSet<Integer> hs = new HashSet<Integer>();
	

	public void addnum() { //product안에 있는 num값만 모으기 
		try {
			db.connect();
			String sql = "select * from product";
			PreparedStatement pstat = db.con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int num = rs.getInt(1);
				hs.add(num); //hashset을 이용해 중복방지
			}

		} catch (SQLException e) {
			System.out.println("Can not excute the query");
		}

	}

	public void delnum(int num) { //hashset에 있는 num제거
		hs.remove(num);
	}

	@Override
	public void insert(Product p) {
		try {
			db.connect();
			String sql = "insert into product values(pro_seq.nextval, '" + p.getName() + "'," + p.getPrice() + ")";
			PreparedStatement pstat = db.con.prepareStatement(sql);
			int count = pstat.executeUpdate();
			if (count > 0) {
				System.out.println("--------------------------------Successful insert!");
			} else {
				System.out.println("--------------------------------Insert Failed");
			}
			addnum();
		} catch (SQLException e) {
			System.out.println("Can not excute the query");
		}

	}

	@Override
	public Product select(int num) {// 일반검색
		addnum();//초기에 addnum()을 호출하므로서 현재 product에 있는 num값을 입력받음
		if (hs.contains(num)) { //입력받은 num값 존재 여부 
			try {
				db.connect();
				String sql = "select * from product where num=" + num;
				PreparedStatement pstat = db.con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();

				while (rs.next()) {
					p.setNum(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setPrice(rs.getInt(3));

				}

			} catch (SQLException e) {
				System.out.println("제품 검색이 실패하였습니다.");
			}
			return p;
		} else {
			System.out.println("다시 입력해주세요");
			return null;
		}
	}

	@Override
	public Vector<Product> selectAll() {// 전체 검색
		v.clear();//vector초기화를 통해 중복 출력 방지
		addnum();//초기에 addnum()을 호출하므로서 현재 product에 있는 num값을 입력받음
		try {
			db.connect();

			String sql = "select * from product";
			PreparedStatement pstat = db.con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
			//	if (!hs.contains(num)) {
					v.add(new Product(num, name, price));
			//	}
			}

		} catch (SQLException e) {
			System.out.println("Can not excute the query");
		}

		return v;
	}

	@Override
	public void delete(int num) {
		addnum();//초기에 addnum()을 호출하므로서 현재 product에 있는 num값을 입력받음
		if (hs.contains(num)) {//입력받은 num값 존재 여부 
			try {
				db.connect();
				// 삭제할 내용을 vector 에서도 삭제하기
//				Iterator<Product> it = v.iterator();
//
//				while (it.hasNext()) {
//					if (it.next().getNum() == num) {
//						it.remove();
//					}
//				}
				String sql = "delete from product where num=" + num;
				PreparedStatement ps = db.con.prepareStatement(sql);
				int count = ps.executeUpdate();
				if (count > 0) {
					System.out.println("--------------------------------Successful Delete!");
				} else {
					System.out.println("Delete Failed");
				}

			} catch (SQLException e) {
				System.out.println("Can not excute the query");
			}
			delnum(num);
		} else {
			System.out.println("번호를 다시 입력해주세요");
		}
		;
	}

	@Override
	public void update(int num, Product p) {
		if (hs.contains(num)) {//입력받은 num값 존재 여부 

			// 중복 출력를 방지하기 위해 수정전 내용을 삭제하기
//			Iterator<Product> it = v.iterator();
//			while (it.hasNext()) {
//				if (it.next().getNum() == num) {
//					it.remove();
//				}
//			}

			try {
				String sql = "update product set name= '" + p.getName() + "', price=" + p.getPrice() + "where num="
						+ num;
				PreparedStatement pstat = db.con.prepareStatement(sql);
				int count = pstat.executeUpdate();
				if (count > 0) {
					System.out.println("--------------------------------Successful Update!");
				} else {
					System.out.println("--------------------------------Update Failed");
				}

			} catch (SQLException e) {
				System.out.println("Can not excute the query");
			}

		} else {
			System.out.println("번호를 다시 입력해주세요");
		}
		
		
		
	}
}
