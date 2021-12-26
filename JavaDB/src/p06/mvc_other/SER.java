package p06.mvc_other;
//	Java 범위의 데이터 다루기

import java.util.Vector;

public interface SER {
	void addProduct(); // insert

	void editProduct(); // update

	void delProduct(); // delete

	DTO_Product getProduct(); // select

	Vector<DTO_Product> getAllProducts(); // selectAll
}
