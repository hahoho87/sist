package begin.control;

public class If {

	public static void main(String[] args) {
		// if(조건식) {
		// 조건식의 결과가 true일 경우
		// 처리할 내용들
		// } 내용이 여러줄 일 경우 중괄호로 묶어줌

		// else if(조건식) {
		// 처음 조건을 만족하지 않는 경우의 처리
		// } else if(조건식) {
		// 두번째 조건도 만족하지 않는 경우의 처리
		// } ... {
		// ... {
		// } else {
		// //위의 조건들을 모두 만족하지 않는 경우의 처리

		// if(조건식) {
		// 처리할 내용들
		// } else {
		// 위의 조건을 만족하지 않을 경우의 처리
		// }

		if (3 < 2) {
			System.out.println("3은 2보다 작다");
		} else {
			System.out.println("3은 2보다 작지 않다.");
		}

		// if(조건식) {
		// 조건식의 결과가 true일 경우 처리할 내용 } - 한 줄이어도 중괄호로 묶어주는 것이 바람직

		if (3 > 2) {
			System.out.println("3은 2보다 크다");
		}

		if (3 != 2) {
			System.out.println("3은 2와 같지 않다");
		}

		int gumae = 19999; // 구매 금액
		int coupon = 0; // 할인 쿠폰

		// 구매 금액이 만원이 넘으면
		// 2000원 할인 쿠폰 발급
		// 할인 쿠폰 발급 메시지 출력
		// 그렇지 않으면
		// 만원 이상 구매시 할인 쿠폰 발급 안내 메시지 출력

		if (gumae >= 10000) {
			coupon = 2000;
			System.out.println(coupon + "원 할인 쿠폰이 발급되었습니다.");
		} else {
			System.out.println("만원 이상 구매시 2천원 할인 쿠폰이 발급됩니다.");
		}

		if (5 > 10) {
			System.out.println("5는 10보다 크다");
		} else if (5 == 10) {
			System.out.println("5는 10과 같다");
		} else if (5 >= 10) {
			System.out.println("5는 10과 같거나 크다");
		} else {
			System.out.println("5는 10보다 크지 않다");
		}
		System.out.println("----------------------");
		// 0 ~ 100사이의 임의의 값을 입력받아
		// 3의 배수인지 출력
		// 출력 형태 : 3의 배수 : O
		// 3의 배수 : X

		int input = 15;
		System.out.println("입력하신 값 : " + input);
		if (0 <= input && input <= 100 && (input % 3 == 0)) {
			System.out.println("3의 배수입니다.");
		} else if (0 <= input && input <= 100 && (input % 3 != 0)) {
			System.out.println("3의 배수가 아닙니다.");
		} else {
			System.out.println("0~100 사이의 값을 입력해주세요.");
		}
		// if안에 if와 else를 넣어서 만드는 방법 연습하기

	}// End main()

} // End class
