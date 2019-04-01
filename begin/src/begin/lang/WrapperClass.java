package begin.lang;

import javax.print.attribute.IntegerSyntax;

public class WrapperClass {
	//기본형을 객체로 변환하는 클래스들
	//int		Integer
	//double	Double
	//	...
	
	public static void main(String[] args) {
		//int형 데이터의 범위 출력
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("------------------------");
		
		Object obj = new Integer(5);
		Object obj2 = new Integer("6");

		Integer i = new Integer(7);
		i = 7;
		
		//unboxing	-> 객체를 기본형으로
		int ii = new Integer(8);	//auto unboxing
		
		//boxing 	-> 기본형을 객체로
		Integer i3 = 9;				//auto boxing	
		
		//프로그램 실행시 명령형 매개변수로 숫자 하나를 입력 받고
		//2배 한 값을 화면에 출력
		int input = Integer.parseInt(args[0]);
		System.out.println(input + " * 2 = " + (input*2));
		
		
		
	}

}
