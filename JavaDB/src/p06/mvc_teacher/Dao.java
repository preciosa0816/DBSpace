package p06.mvc_teacher;

import java.util.Vector;

public interface Dao {
	
	void insert(Product p);
	Product select(int num);
	//ArrayList<Product> seletAll();//전체 검색
	Vector<Product> selectAll();
	void delete(int num);
	void update(int num, Product p);
}
