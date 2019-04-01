package exercise.oop;

public class ConstructorGetSetBankMain {

	ConstructorGetSetBank k;
	// ConstructorGetSetBank 클래스에 있는 변수들을 사용하기 위하여
	// 클래스 변수를 선언하지만, 여기서 new 클래스(); 로 객체 생성까지 하면
	// 변경이 불가능하기 때문에 선언까지만 한다.

	// 입금 메소드

	public void deposit(int input) { // 입금 메소드 생성. 매개변수는 있지만 반환값은 없기 때문에 void로 작성
		k.setBalance(k.getBalance() + input); // 새로운 잔고 = 잔고+입금액이므로
												// ConstructorGetSetBank 의 밸런스 필드에 들어있는 값을 사용하기 위하여
												// 잔액의 setter를 잔액의 getter값 + 입금액으로 설정해준다.
		//
		System.out.println(input + "원 입금완료" + "\n" + "현재잔고 : " + k.getBalance() + "원"); // 입금액과 현재 잔고 출력문
	}

	public int withdraw(int output) { // 출금 메소드

		if (k.getBalance() >= output) { // 잔액이 출금액보다 같거나 많으면
			k.setBalance(k.getBalance() - output); // 잔액에서 출금액을 뺀 후에 balance에 setter에 다시 지정해준다
			System.out.println(output + "원 출금완료"); // 출금액 출력문
			return output; // 반환값이 있으므로 return 사용 후에 출금액을 반환
		} else { // 잔액이 출금액보다 적으면
			System.out.println("출금 요청액 : " + output + "원");
			System.out.println("잔고가 부족합니다."); // 출금 불가 메시지 출력
			return 0; // 0을 반환
		}

	}

	public void printBalance() {
		System.out.println("현재 잔고 : " + k.getBalance() + "원"); // 현재 잔고 출력문
	}

	public static void main(String[] args) {

		ConstructorGetSetBankMain m = new ConstructorGetSetBankMain();
		
		// ConstructorGetSetBank 클래스의 생성자를 이용하여
		// 객체를 생성
		// 단, 게좌번호 : 3333, 예금주 : 김씨. 잔고 : 5000원
		// static이 있는 main 클래스에서 static이 없는 외부의 메소드의 객체들을
		// 사용하기 위해서 m. 을 통해 ConstructorGetSetBankMain 필드에 접근 할 수 있게 한다.

		m.k = new ConstructorGetSetBank(3333, "김씨", 5000);
		// 계좌번호와 예금주, 잔고를 매개변수로 받아서
		// 초기화하는 생성자에 자료를 넣기 위하여
		// m.k로 ConstructorGetSetBankMain의 static이 없는 클래스에서
		// 다시 ConstructorGetSetBank 클래스로 빠져나간 후에
		// 계좌번호, 예금주, 잔고 초기화

		// 최초 잔고 출력
		// 입금 555원
		// 출금 10000원
		// 출금 5000원
		// 최종 잔고 출력

		m.printBalance(); // 잔고 출력 메소드 실행
		m.deposit(555); // 입금 메소드 실행
		m.withdraw(10000); // 출금 메소드 실행
		m.withdraw(5000); // 출금 메소드 실행
		m.printBalance(); // 잔고 출력 메소드 실행 

	}

}
