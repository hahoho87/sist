package exercise.io;

public class LoginCheck {

	private String id = "admin";
	private String pw = "1234";

	public boolean loginCheck(String id, String pw) {
		if (this.id.equals(id) && this.pw.equals(pw)) {
			return true;
		} else
			return false;
	}

	// 접근제한 : 패키지 및 클래스 구분없이 사용 가능
	// 메소드명 : loginCheck
	// 매개변수 : String, String
	// 반환값 : boolean
	// 기능 : 매개변수로 넘겨받은 값이 멤버 변수의
	// 값과 일치하면 true, 그렇지 않으면 false 반환

}
