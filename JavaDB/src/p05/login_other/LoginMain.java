package p05.login_other;

public class LoginMain {
	static ScanChecker sc = new ScanChecker();
	static DAO_LoginSVC dao = new DAO_LoginSVC();

	public static void main(String[] args) {
		dao.connect();

		boolean toggle = false;
		while (!toggle) {
			System.out.println();
			System.out.println("┌───────────────┐");
			System.out.println("│ 1. 로그인\t│");
			System.out.println("│---------------│");
			System.out.println("│ 2. 비밀번호 변경\t│");
			System.out.println("│ 3. 아이디 만들기\t│");
			System.out.println("│---------------│");
			System.out.println("│ 4. 아이디 찾기\t│");
			System.out.println("│ 5. 비밀번호 찾기\t│");
			System.out.println("│---------------│");
			System.out.println("│ 6. 접속종료\t│");
			System.out.println("└───────────────┘");
			System.out.print("└ 번호 선택 : ");
			int n = sc.ScanInt();

			switch (n) {
			case 1:
				login();
				break;
			case 2:
				passwordChanger();
				break;
			case 3:
				idMaker();
				break;
			case 4:
				idFinder();
				break;
			case 5:
				passwordFinder();
				break;
			case 6:
				dao.done();
				toggle = true;
				break;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}
	}

	static private void login() {
		System.out.println("\n[로그인]");
		System.out.println("아이디와 비밀번호를 입력하세요.");

		System.out.print("아이디 : ");
		String id = sc.ScanString();
		System.out.print("비밀번호 : ");
		String password = sc.ScanString();

		DTO_User user = dao.loginCheck(id, password);

		if (user != null) {
			System.out.println("\n[로그인 성공]");
			System.out.println("사용자 정보");
			System.out.println(user);
		} else {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
		}
	}

	static private void passwordChanger() {
		System.out.println("\n[비밀번호 변경]");
		System.out.println("비밀번호를 변경할 아이디를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.ScanString();
		System.out.print("비밀번호 : ");
		String password = sc.ScanString();
		System.out.print("변경 할 비밀번호 : ");
		String changePassword = sc.ScanString();

		dao.passwordUpdate(id, password, changePassword);
	}

	static private void idMaker() {
		System.out.println("\n[아이디 생성]");
		System.out.print("아이디\t: ");
		String id = sc.ScanString();
		System.out.print("비밀번호\t: ");
		String password = sc.ScanString();
		System.out.print("이름\t: ");
		String name = sc.ScanString();
		System.out.print("나이\t: ");
		int age = sc.ScanInt();
		System.out.print("주소\t: ");
		String address = sc.ScanString();
		System.out.print("이메일\t: ");
		String email = sc.ScanString();

		dao.idInsert(id, password, name, age, address, email);
	}

	static private void idFinder() {
		System.out.println("\n[아이디 찾기]");
		System.out.print("이름\t: ");
		String name = sc.ScanString();
		System.out.print("이메일\t: ");
		String email = sc.ScanString();

		dao.idSelect(name, email);
	}

	static private void passwordFinder() {
		System.out.println("\n[비밀번호 찾기]");
		System.out.print("아이디\t: ");
		String id = sc.ScanString();
		System.out.print("이름\t: ");
		String name = sc.ScanString();
		System.out.print("이메일\t: ");
		String email = sc.ScanString();

		dao.passwordSelect(id, name, email);
	}
}