package exercise.oop;

public class StaticBank {

	
	//변수에도 static을 붙여준다
	static int accoutNo;
	static String name;
	static int jango;

	public static void deposit(int input) {
		jango = jango + input;
		System.out.println(input + "원 입금완료");
		System.out.println("현재잔교 : " + jango + "원");
	}

	public static int withdraw(int output) {
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

	public static void printJango() {
		System.out.println("현재 잔고 : " + jango + "원");
	}

}
