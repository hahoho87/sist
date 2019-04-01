package begin.oop;

public class Method {
	// 접근제한자 반환데이터타입|void 메서드명(매개변수) {
	// 처리할 내용들
	// return 반환값;
	// }

	// 매개 변수와 반환값이 없는 경우
	// 접근 제한자 void 메서드명( ) {
	// 처리할 내용들
	// }

	// 매개 변수는 있고 반환값이 없는 경우
	// 접근제한자 void 메서드명 (매개변수) {
	// 처리할 내용들
	// }

	// 매개 변수와 반환값이 모두 있는 경우
	// 접근제한자 반환데이터타입 메서드명(매개변수) {
	// 처리할 내용들
	// }

	// 매개 변수는 없고 반환값은 있는 경우
	// 접근제한자 반환데이터타입 메서드명(매개변수) {
	// 처리할 내용들
	// return 반환값;
	// }

	public static void add() { // 매개 변수와 반환값이 없는 경우
		System.out.println("3 + 4 = 7");
	}

	public static void add(int num) { // 매개 변수는 있고 반환값이 없는 경우
		System.out.println("3 + " + num + " = " + (3 + num));

	}

	public static int add(int num1, int num2) { // 매개 변수와 반환값이 모두 있는 경우
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		return num1 + num2;

	}

//	public static int add()	{	//같은 클래스 안에 같은 메서드를 사용 할 수 없다
	public static int addnums() { // 매개 변수는 없고 반환값은 있는 경우
		System.out.println("addnums");
		return 3 + 4; // 반환값은 데이터타입과 일치해야 한다.
	}

	// var args
	public static int add(int... n) {
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum = sum + n[i];
		}
		return sum; // 반환에 대한 개념 이해하기
	}

	// 재귀함수
	// 특정 메서드 내에서 자기 자신을 다시 호출하는 함수
	// ex) 팩토리얼 구현
	// 5! = 5 * 4 * 3 * 2 * 1

	public long factorial(int num) {
		long result = 0L;
		if (num == 1)
			result = 1;
		else
			result = num * factorial(num-1);

		return result;
	}

	public static void main(String[] args) {
		
		Method met = new Method();			//factorial 에는 static이 붙어있지 않기 때문에 
											//메소드를 불러오는 함수 작성
		System.out.println(met.factorial(4));

		add(1, 2, 3, 4, 5);
		add(6, 7, 8, 9, 10, 11, 12, 13, 14);
		System.out.println(add(1, 2, 3, 4, 5));
		System.out.println(add(6, 7, 8, 9, 10, 11, 12, 13, 14));

		add(); // 매개변수와 반환값이 없는 add( ) 메서드 호출
		add(40); // 매개변수는 있고 반환값이 없는 add 메서드 호출
		add(30, 40); // 매개변수와 반환값이 모두 있는
		addnums();

		// 매개변수와 반환값이 모두 있는 add 메서드 호출하고
		// 반환되는 값을 result 변수에 저장하고
		// 화면에 출력
		int result = add(5, 6);
		System.out.println(result);

		System.out.println("main() END");
	}

}
