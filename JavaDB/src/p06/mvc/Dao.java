package p06.mvc;
//DAO : DB접근 해서 저장 데이터 가져오기

import java.util.Vector;

public interface Dao {
//추상메소드
	void insert(Product p); // DB에 저장
	Product select(int num); //특정 자료 검색
	
	//ArrayList<Product> selectAll(); 
	Vector<Product> selectAll(); // 전체 검색
	//Vector는 동기적, ArrayList는 비동기적
	
	void delete(int num);//data 삭제
	void update(int num, Product p);// data 수정
}
