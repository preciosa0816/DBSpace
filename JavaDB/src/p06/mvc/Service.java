package p06.mvc;

import java.util.Vector;

public interface Service {
	void addProduct();  //insert
	void editProduct(); //update
	void delProduct(); //delete
	
	Product getProduct(); //select
	
	Vector<Product> getProducts(); //selectAll
}
