package begin;

public class Variable {

	public static void main(String[] args) {
		
		//정수형 상수 MAX 선언 및 초기화
		final int MAX = 123;
//		MAX = 465465;
		
		//int형 자료의 최소값과 최대값을 출력
		System.out.println("최소값 :" + Integer.MIN_VALUE);
		System.out.println("최대값 : " + Integer.MAX_VALUE);
		
		
		
		//문자열 변수 선언
		char c, cc, ccc;			//2byte 0~255까지 가능
		c= 'A';
		cc = 65;
		ccc = '\u0041';
		
		System.out.println(c);
		System.out.println(cc);		//ASKII 코드 10진법 - A
		System.out.println(ccc);	//ASKII 코드 16진법 - A
		
		System.out.print(c + "\t\"");
		System.out.print(cc + "\\\t");
		System.out.print(ccc + "\n");	// \n:줄바꿈, \t:탭
		
		//논리값 변수 선언
		boolean bool;	//true or false 값 저장
		bool = true;
		bool = false;
		
		bool = 5 > 2;
		System.out.println(bool);	//true 출력
		
		bool = 5 > 20;
		System.out.println("bool:" + bool);	//false 출력
		
		
		//정수형 변수 선언
		byte	b;	//1byte
		short	s;	//2byte
		int		i;	//4byte
		long	l;	//8byte
		
		//정수형 변수에 값 저장/대입/초기화
		b = 100;
		s = 10000;
		i = 1000000;
		l = 1000000000000L;
		
		//정수형 변수 선언 및 초기화
		byte bb = 100;
		short ss = 10000;
		int ii = 1000000;
		long ll = 100000000000L;
		//long ll = (long) 100000000000L;  (long)은 생략가능
		ll = 100000000;
		
		ii = (int) 1000000000000L;
		
		
		//실수형 변수 선언
		float f;	//4byte
		double d;	//8byte
		
		//실수형 변수의 값 초기화/대입/저장
//		f = 0.123456789;			//float에 double 저장 불가
		f= 0.123456789f;			//f를 붙여서 저장 or
		f = (float) 0.123456789;	//형변환으로 해결
		d = 0.123456789;

		
		//화면에 출력
		System.out.println("bb:" + bb);
		System.out.println("ss:" + ss);
		System.out.println("ii:" + ii);		//값 손실 발생
		System.out.println("ll:" + ll);
		
		System.out.println(f);	//값 손실 발생

	}

}
