package exercise.oop;

public class ConstructorGetSetBank {
	// 계좌번호, 예금주, 잔고를
	// 클래스 외부에서 접근 할 수 없도록 선언
	private int accountNo; // 매개변수로 저장한 account 필드를 외부에서 접근할 수 없도록 선언
	private String name; // 매개변수로 저장한 name 필드를 외부에서 접근할 수 없도록 선언
	private int balance; // 매개변수로 저장한 balance 필드를 외부에서 접근할 수 없도록 선언


	public ConstructorGetSetBank(int accountNo, String name, int balance) {
		// 계좌번호와 예금주, 잔고를 매개변수로 받아서
		// 초기화하는 생성자 작성
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		// 필드와 매개변수의 이름이 동일하기 때문에
		// 생성자 내부에서 해당 필드에 접근 할 수 없다.
		// (매개변수의 사용 우선순위가 높으므로)
		// 따라서 this.필드 = 매개변수 를 통해 참조변스로 필드를 사용한다
	}

	// 멤버 변수들의 값을 외부에서 접근할 수 있도록
	// getter, setter 작성

	public int getAccountNo() { // 저장된 멤버변수 accountNo를 받아오기 위한 getter 생성
								// getter는 매개변수는 없지만 반환값은 있기 때문에 void를 쓰지 않는다
		return accountNo; // getter의 반환값인 계좌번호를 리턴 받아옴
	}

	public void setAccountNo(int accountNo) { // 계좌번호 매개변수를 멤버변수에 저장하기 위한 setter 생성
		this.accountNo = accountNo;	//계좌번호 필드를 사용하기 위해 this 사용
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {	// 이름 매개변수를 멤버변수에 저장하기 위한 setter 생성
		this.name = name;	//이름 필드를 사용하기 위해 this 사용
	} 

	public int getBalance() {
		return balance;
	} // 멤버변수를 받아오기 위한 getter 생성

	public void setBalance(int balance) {
		this.balance = balance;
	} // 잔액 매개변수를 멤버변수를 저장

}
