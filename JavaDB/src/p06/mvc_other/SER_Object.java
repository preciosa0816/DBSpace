package p06.mvc_other;

import java.util.Vector;

public class SER_Object implements SER {
	ScanChecker sc = new ScanChecker();
	DAO_Oracle daoOracle = new DAO_Oracle();

	@Override
	public void addProduct() {
		System.out.println("[제품등록]");
		System.out.print("  1. 제품이름 : ");
		String name = sc.ScanString();
		System.out.print("  2. 제품가격 : ");
		int price = sc.ScanInt();

		DTO_Product p = new DTO_Product(name, price);
		daoOracle.insert(p);
	}

	@Override
	public void editProduct() {
		System.out.println("[제품수정]");
		System.out.print("  1. 제품번호 : ");
		int num = sc.ScanInt();
		DTO_Product p1 = daoOracle.select(num);
		if (p1 != null) {
			System.out.println(p1);

			System.out.print("  2. 수정이름 : ");
			String name = sc.ScanString();
			System.out.print("  3. 수정가격 : ");
			int price = sc.ScanInt();

			DTO_Product p2 = new DTO_Product(name, price);
			daoOracle.update(num, p2);

			System.out.println("[수정결과]");
			System.out.println(daoOracle.select(num));
		} else {
			System.out.println("해당 번호의 제품이 없습니다.");
		}
	}

	@Override
	public void delProduct() {
		System.out.println("[제품삭제]");
		System.out.print("삭제할 제품번호 : ");
		int num = sc.ScanInt();

		DTO_Product p1 = daoOracle.select(num);
		if (p1 != null) {
			daoOracle.delete(num);
		} else {
			System.out.println("해당 번호의 제품이 없습니다.");
		}
	}

	@Override
	public DTO_Product getProduct() {
		System.out.println("[제품검색]");
		System.out.print("검색할 제품번호 : ");
		int num = sc.ScanInt();
		return daoOracle.select(num);
	}

	@Override
	public Vector<DTO_Product> getAllProducts() {
		System.out.println("[전체검색]");
		return daoOracle.selectAll();
	}

	public void close() {
		daoOracle.close();
		sc.close();
	}
}
