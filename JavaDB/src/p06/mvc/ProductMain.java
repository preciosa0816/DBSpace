package p06.mvc;

import java.util.Scanner;
//Controller, View
public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int menu;
		Service service = new ServiceImpl();
		//Product p = null;
		//Vector<Product> v = new Vector<Product>();
		
		
		while (flag) {
			System.out.println("1. 제품등록 | 2. 제품검색 | 3. 전체검색 | 4. 수정 | 5. 삭제 | 6. 종료");
			System.out.print("입력> ");
			menu = sc.nextInt();
			if(menu==1) {
				service.addProduct();

			}else if (menu==2) {
				service.getProduct();
				
			}else if(menu==3) {
				service.getProducts();
				
			}else if(menu==4) {
				service.editProduct();
				
			}else if(menu==5) {
				service.delProduct();
				
			}else if(menu==6) {
				System.out.println("----종료합니다----");
				flag=false;
				sc.close();
				break;
				
			}else {
				System.out.println("번호 확인후 다시 입력해 주세요");
			}
		}
	}

}
