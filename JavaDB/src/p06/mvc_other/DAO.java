package p06.mvc_other;
//	DB 범위의 데이터 다루기

//import java.util.ArrayList;
import java.util.Vector;

public interface DAO {
	void insert(DTO_Product p); // DB에 저장

	DTO_Product select(int num); // Select의 결과를 DTO의 형태로 저장

//	ArrayList<DTO_Product> selectAll();
	Vector<DTO_Product> selectAll(); // ArrayList의 비동기 버전인 Vector 이용

	void delete(int num); // 삭제

	void update(int num, DTO_Product p);
}
