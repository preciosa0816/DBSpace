package p05.login_other;

public class DTO_User {
	private String id;
	private String password;
	private String name;
	private int age;
	private String address;
	private String email;

	public DTO_User(String id, String password, String name, int age, String address, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age + "\n주소 : " + address + "\n이멜 : " + email;
	}
}
