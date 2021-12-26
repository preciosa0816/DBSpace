package p05.java_login_db_test;
//DTO=VO=Bean
public class User {
	private String id;
	private String passwd;
	private String name;
	private int age;
	private String addr;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//입력
	
	@Override
	public String toString() {
		
		return "아이디 : "+id+" 비밀번호 : "+passwd+" 이름 : "+name+" 나이 : "+age+" 주소 : "+addr+" 이메일 : "+email  ;
	}
	
	
	
	
}
