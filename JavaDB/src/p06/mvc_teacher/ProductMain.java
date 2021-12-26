package p06.mvc_teacher;

import java.util.Scanner;
import java.util.Vector;

public class ProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int menu;
		Service service = new ServiceImpl();
		Product p = null;
		Vector<Product> v = null;
		while (flag) {
			System.out.println("1.제품등록 2.제품검색 3.전체검색 4.수정 5.삭제 6.종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				service.addProduct();
				break;
			case 2:
				p = service.getProduct();
				System.out.println(p);
				break;
			case 3:
				v = service.getProducts();
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i));
				}
				break;
			case 4:
				service.editProduct();
				break;
			case 5:
				service.delProduct();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("다시 입력하라");
			}
		}
		sc.close();
	}

}
