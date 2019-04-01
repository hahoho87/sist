package exercise.oop;

public class MethodExam {
	
	
	
	

	//var args와 foreach를 이용하여
	//임의의 불특정 다수의 정수를 모두 더하고
	//결과를 화면에 출력하는 add 메서드 작성	 => 다시 해보자....
	
	public static void add(int ... n) {
		int sum = 0;
		for (int i : n) {
			sum = sum + i;
		}
		System.out.println(sum);
	}
	
	
	
	// 정수 5개를 매개변수로 넘겨받아 모두 더한 값을
	// 반환하는 add 메서드 작성
	
	public static int add(int n1, int n2,
						int n3, int n4, int n5) {
		return n1 + n2 + n3 + n4 + n5;
	}

	// 정수 3개를 매개변수로 넘겨받아 모두 더한 값을
	// 반환하는 add 메서드 작성
	public static int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;

	}

	// 위의 메서드를 호출하여
	// 임의의 정수에 반환값을 저장하고
	// 화면에 출력
	public static void main(String[] args) {
		add(1, 3, 5, 7, 9, 11, 13);
		
		
		
		int result = add(1, 5, 7);
		System.out.println(result);

		// 반지름 * 반지름 * 원주율을 계산한
		// cal 메서드를 호출하고 반환값을 저장

		double circle = cal(3, 3, 3.14);
		System.out.println(circle);
		

	}

	

	public static double cal(int i, int j, double d) {
		return i * j * d;
	}
}