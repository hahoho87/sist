package exercise.oop;

public class InstanceBank {

	int accountNo; // 계좌번호
	String name; // 예금주
	int jango; // 잔액

	public void deposit(int input) {
		jango = jango + input;
		System.out.println(input + "원 입금완료" + "\n" + "현재잔고 : " + jango + "원");
	}

	// 입금 method deposit
	// 매개변수 : 입금액
	// 반환값 : 없음
	// 기능 : 매개변수로 넘겨받은 금액을 잔고에 더하고
	// 처리결과를 화면에 출력 : "~~원 입금 완료"

	public int withdraw(int output) {

		if (jango >= output) {
			jango = jango - output;
			System.out.println(output + "원 출금완료");
			return output;
		} else {
			System.out.println("출금 요청액 : " + output + "원");
			System.out.println("잔고가 부족합니다.");
			return 0;
		}

	}
	// 출금 메서드 withdraw
	// 매개변수 : 출금액
	// 반환값 : 출금액
	// 기능 : 매개변수로 넘겨받은 금액이 출금 가능하면 출금처리
	// or 출금 불가 안내 메시지 출력

	public void printJango()	{
		System.out.println("현재 잔고 : " + jango + "원");
	}

	// 잔고 조회 메서드 printJango
	// 매개변수 : 없음
	// 반환값 : 없음
	// 기능 : 현재 잔고를 화면에 출력
	// "현재 잔고 : ~~원"

	// 메서드 들은 모두 static 사용x

}
