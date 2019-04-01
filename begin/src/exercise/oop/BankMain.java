package exercise.oop;

public class BankMain {

	public static void main(String[] args) {

	

		StaticBank.accoutNo = 2222;
		StaticBank.name = "공유";
		StaticBank.jango = 1000;
		StaticBank.printJango();
		StaticBank.deposit(500);
		StaticBank.withdraw(2000);
		StaticBank.withdraw(1000);
		StaticBank.printJango();

		System.out.println("--------------");

		// staticBank 클래스를 이용하여
		// 계좌번호 : 2222
		// 예금주 : 공유
		// 잔고 : 1000
		// 입금 : 500
		// 출금 : 2000
		// 출금 : 1000

		// static에 들어있는 메소드는 어디에서나 사용 가능
		// 아닌 경우는 따로 지정을 해줘야...
		// ex) InstanceBank user1 = new InstanceBank();
		// 전체를 관리할 때는 static을 이용하여 메소드 작성
		// 개개인을 관리 할 때에는 static 없이 개개인 지정 후에 사용

		InstanceBank user1 = new InstanceBank();
		user1.name = "Kimleepark";
		user1.accountNo = 1111;
		user1.jango = 10000;

		user1.printJango();
		user1.deposit(5000);
		user1.withdraw(20000);
		user1.withdraw(10000);
		user1.printJango();

		// InstanceBank 클래스의 참조변수 user1을 생성
		// 계좌번호 : 1111
		// 예금주 : "Kimleepark"
		// 잔고 : 10000 으로 지정

		// 입금 : 5000
		// 출금 : 20000
		// 출금 : 10000

	}

}
