package p06.mvc_teacher;

import java.util.Scanner;
import java.util.Vector;

public class ServiceImpl implements Service {
	Scanner sc = new Scanner(System.in);
	Dao dao = new OracleDao();

	@Override
	public void addProduct() {
		
		System.out.print("제품이름:");
		String name = sc.next();
		System.out.print("제품가격:");
		int price = sc.nextInt();

		dao.insert(new Product(0, name, price));

	}

	@Override
	public void editProduct() {
		
		System.out.print("수정할 제품번호:");
		int num = sc.nextInt();
		Product p = dao.select(num);
		if (p == null) {
			System.out.println("해당 제품이 없다.");
		} else {
			System.out.println(p);
			System.out.print("새 제품이름:");
			String name = sc.next();
			System.out.print("새 제품가격:");
			int price = sc.nextInt();

			p.setName(name);
			p.setPrice(price);
			dao.update(p.getNum(), p);
		}
	}

	@Override
	public void delProduct() {
	
		System.out.print("삭제할 제품번호:");
		int num = sc.nextInt();
		dao.delete(num);
	}

	@Override
	public Product getProduct() {
		
		System.out.print("검색할 제품번호:");
		int num = sc.nextInt();
		Product p = dao.select(num);
		return p;
	}

	@Override
	public Vector<Product> getProducts() {
	
		return dao.selectAll();
	}

}
