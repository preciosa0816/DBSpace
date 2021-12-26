package p06.mvc;

import java.util.Scanner;
import java.util.Vector;

//Model
public class ServiceImpl implements Service {
	OracleDao od = new OracleDao();
	Scanner sc = new Scanner(System.in);
	Product p = new Product();
	
	
	@Override
	public void addProduct() {// insert
		System.out.print("제품 이름 : ");
		String name = sc.next();
		p.setName(name);
		System.out.print("제품 가격 : ");
		int price = sc.nextInt();
		p.setPrice(price);
		od.insert(p);
		
		
	}

	@Override
	public void editProduct() {// update
		System.out.print("수정할 제품 번호 : ");
		int num = sc.nextInt();
		p=od.select(num);
		if(od.hs.contains(num)) {
		System.out.println(p);
		System.out.print("새 제품이름 : ");
		String name = sc.next();
		p.setName(name);
		System.out.print("새 제품가격 : ");
		int price = sc.nextInt();
		p.setPrice(price);
		od.update(num, p);
		}

	}

	@Override
	public void delProduct() {// delete
		System.out.print("삭제할 제품 번호 : ");
		int num = sc.nextInt();
		od.delete(num);
		
		
	}

	@Override
	public Product getProduct() {// select
		System.out.print("검색할 제품번호 : ");
		int num = sc.nextInt();
		p=od.select(num);
		System.out.println(p);
		return null;
		
	}

	@Override
	public Vector<Product> getProducts() { // selectAll
		System.out.println("------oracle selectAll------");
		Vector<Product>v=od.selectAll();
		
		for(Product p:v ) {
			System.out.println("Product [num=" + p.getNum() + ", name=" + p.getName() + ", price=" + p.getPrice() + "]");
		}
		System.out.println("------------------------------");
		return null;
	}
	

}
