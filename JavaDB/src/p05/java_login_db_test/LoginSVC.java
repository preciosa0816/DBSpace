package p05.java_login_db_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO
public class LoginSVC {
	Connection con;
	ArrayList<User> us = new ArrayList<User>();
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static {// static 초기화 블록(가장 먼저 수행될 것)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar인 Orcle Driver가 없습니다.");
		}
	}
	
	public void connect() {

		try {
			con = DriverManager.getConnection(url, "javaDB", "javadb");
			System.out.println("Connection Success!");

		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}


		
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from member2";
			stmt.execute(sql);
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				//connect(); -loginMain 대신
				User user = new User();
				String id = rs.getString(1);
				String passwd = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String addr = rs.getString(5);
				String email= rs.getString(6);
				
				user.setId(id);
				user.setPasswd(passwd);
				user.setName(name);
				user.setAge(age);
				user.setAddr(addr);
				user.setEmail(email);
				us.add(user);
				
			}
		} catch (SQLException e) {
			System.out.println("입출력이 어렵습니다.");
		}
		
		
	}
	
	public User login(String id, String passwd) {
			for (int i=0; i<us.size();i++) {
					if(id.equals(us.get(i).getId()) & passwd.equals(us.get(i).getPasswd())){
						return us.get(i);
					}
					
			}
			return null;
		
		
//		
//				
//				return us ;
//				//System.out.println("아이디 : "++"비밀번호 : "+"이름 : "+"나이 : "+"주소 : "+"이메일 : "  );
//			}else {
//				return null;
//			}
		
		
	}
}
