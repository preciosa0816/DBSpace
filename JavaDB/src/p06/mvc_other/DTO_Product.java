package p06.mvc_other;

public class DTO_Product {
	private int num;
	private String name;
	private int price;

	public DTO_Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public DTO_Product(int num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	@Override
	public String toString() {
		String str = "[ 상품번호 : " + num + " | 상품명 : " + name + " | 가격 : " + price + " ]";
		return str;
	}

}
