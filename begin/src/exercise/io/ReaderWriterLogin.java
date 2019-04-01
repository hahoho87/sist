package exercise.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderWriterLogin {

	public static void main(String[] args) {
		// 사용자로부터 아이디와 비밀번호를 입력받은 후
		// LoginCheck 클래스의 loginCheck 메소드를 호출하여
		// 확인 결과를 넘겨받은 후
		// true 이면 "관리자 로그인 완료"를 출력
		// 그렇지 않으면 "아이디 또는 비밀번호가 일치하지 않습니다."를 출력
		LoginCheck lc = new LoginCheck();

		System.out.println("----Login System----");
		// 키볻 입력을 BufferdReader로 연결
		System.out.print("ID : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id = null;
		try {
			id = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Password : ");
		String pw = null;
		try {
			pw = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lc.loginCheck(id, pw) == true) {
			System.out.println("관리자 로그인 완료!");
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
