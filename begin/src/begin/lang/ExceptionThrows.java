package begin.lang;

public class ExceptionThrows 
{
	//throw 예외 던지기
	// 특정 메서드에서 발생한 예외를 직접 처리하지 않고(try / catch)
	// 해당 메서드를 호출한 쪽으로 예외를 던져서 처리하도록 메서드 선언부에 명시 (복수 선언 가능)
	
	// 정수형 변수 2개를 매개변수로 넘겨받아서 나눈 결과를 출력하는 인스턴스 메서드 divide 작성
	
	//예외 직접 처리하기
	public void divide(int a, int b)
	{
		// try{} catch{} 구문 만드는 방법 : 예외 부분인 System.out.println(a/b); 드래그 + 우클릭 + surround with -> try/catch 블록	
		try 
		{
			System.out.println(a/b); //실제로 예외가 발생한 부분
		} 
		catch (ArithmeticException e) 
		{	
			System.out.println("0으로 나누기 금지");
		}
	}
	
	//예외를 직접 처리하지 않고 호출한 곳으로 던짐
	public void divide2(int a, int b) throws ArithmeticException
	{	
		System.out.println(a/b);
	}
	public static void main(String[] args) 
	{   
		// 5와 0을 실매개변수 값으로 divide 메서드 호출
		new ExceptionThrows().divide(5,0);
		
		// 5와 0을 실매개변수 값으로 divide2 메서드 호출
		try {
			new ExceptionThrows().divide2(5,0);
		} catch (ArithmeticException e) {
			System.out.println();
			e.printStackTrace();
		}
		
	}// END main()

}// END class
