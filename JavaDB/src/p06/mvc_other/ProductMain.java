package p06.mvc_other;
//	Controller, View 기능 수행

import java.util.Vector;

public class ProductMain {
	public static void main(String[] args) {

		ScanChecker sc = new ScanChecker();
		SER_Object serviceObject = new SER_Object();

		boolean toggle = false;
		do {
			System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┓");
			System.out.println("┃ 1. 제품등록\t┃ 2. 제품검색\t┃ 3. 전체검색\t┃");
			System.out.println("┣━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━┫");
			System.out.println("┃ 4. 제품수정\t┃ 5. 제품삭제\t┃ 6. 검색종료\t┃");
			System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┛");
			System.out.print("┗ 번호 입력 : ");
			int selectNum = sc.ScanInt();

			switch (selectNum) {
			case 1:
				serviceObject.addProduct();
				break;
			case 2:
				DTO_Product p = serviceObject.getProduct();
				if (p != null) {
					System.out.println(p);
				} else {
					System.out.println("해당 번호의 제품이 없습니다.");
				}
				break;
			case 3:
				Vector<DTO_Product> productsVector = serviceObject.getAllProducts();
				for (DTO_Product v : productsVector) {
					System.out.println(v);
				}
				break;
			case 4:
				serviceObject.editProduct();
				break;
			case 5:
				serviceObject.delProduct();
				break;
			case 6:
				toggle = true;
				serviceObject.close();
				sc.close();
				System.out.println("\n[프로그램 종료]");
				break;
			default:
				System.out.println("1~6 사이의 숫자를 입력해주세요.");
				break;
			}
		} while (!toggle);

	}
}
