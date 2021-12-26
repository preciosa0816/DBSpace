package p04.mvc_pattern;

//VO = Bean = DTO (Data Transfer Object : 클래스를 통해 데이터 이동 - from java to java)
public class SampleDTO {

//	id varchar2(20) primary key,
//	name varchar2(20),
//	price number(10)
	String id;
	String name;
	int price;
	public SampleDTO() {
		
	}
	public SampleDTO(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	// getter()&setter()
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}



	
	
}
