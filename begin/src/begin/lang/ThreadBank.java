package begin.lang;

import java.util.Random;

class Bank {

	int accountNo; // 계좌번호
	String name; // 예금주
	int jango; // 잔액

	// 이름과 금액을 매개변수로 받아서 화면에 출력하는 생성자 작성
	// 금액은 잔고에 저장
	Bank(String name, int money) {
		this.name = name;
		jango = money;
		System.out.println("Bank 생성자 : 초기입금 " + money);
	}// End 생성자

	public synchronized void deposit(int input, String name) {

		jango = jango + input;
		System.out.println(name + " : " + input + "원 입금 완료 \t현재 잔액 : " + jango);
	}

	public synchronized void withdraw(int output, String name) {

		if (jango >= output) {
			jango = jango - output;
			System.out.println(name + " : " + output + "원 출금 완료 \t 현재잔액 : " + jango);
			output = jango;
		} else {
			System.out.println(name + " : " + "출금 요청액 : " + output + "원" + " << 잔고부족 출금 불가");
			output = 0;

			try {
				wait(); // 스레드 대기 요청
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void printJango() {
		System.out.println("현재 잔고 : " + jango + "원");
	}

}// End Bank

class BankRun extends Thread {
	private boolean flag;
	private Bank bank;

	public BankRun(String name, Bank bank) {
		super(name);
		this.bank = bank;
	}

	public void run() { // 스레드 처리할 내용
		// flag값이 true이면 입금
		// false이면 출금 메서드를 임의로 0.5초마다 실행
		// 단, flag값도 임의로 변경
		for (int i = 0; i < 5; i++) {

			Random r = new Random();
			flag = r.nextBoolean();

			int money = (int) (Math.random() * 10 + 1) * 100; // 100 ~ 1000 사이 100 단위를 임의로 추출하여
			if (flag == true) {
				bank.deposit(money, getName());
			}
			if (flag != true) {
				bank.withdraw(money, getName());
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}// End BankRun

public class ThreadBank {

	public static void main(String[] args) {
		// Bank 클래스의 참조변수 b생성
		Bank b = new Bank("", 1000);

		// BankRun 클래스의 객체 b1(부장), b2(과장), b3(경리) 생성
		BankRun b1 = new BankRun("부장", b);
		BankRun b2 = new BankRun("과장", b);
		BankRun b3 = new BankRun("경리", b);
		// b1, b2, b3를 이용하여 BankRun 클래스의 run 메소드 실행
		b1.start();
		b2.start();
		b3.start();

	}// End main

}// End ThreadBank
