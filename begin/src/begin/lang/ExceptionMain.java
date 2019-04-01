package begin.lang;

import java.util.Date;

public class ExceptionMain // 예외상황 만들어서 봐보기 (책 721쪽)
{	// 에러 : 하드웨어 등의 잘못된 동작 또는 고장
	//		에러 발생 시 프로그램 종료
	// 		정상 실행 상태로 돌아갈 수 없음
	// 예외 : 일반적이지 않은 상황
	//		예외 발생시 프로그램 종료
	// 	   	예외 처리를 추가하면 정상 실행 상태로 돌아갈 수 있음
	
	// 예외 발생의 예
	// 0으로 나누는 경우
	// 배열의 인덱스를 벗어나는 범위를 참조하는 경우
	// 부적절한 형변환
	// I/O 처리에서 입출력 파일이 없는 경우 등

	// 예외 처리하는 방법
	// try
	// {
	//	예외가 발생할 수 있는 코드 블럭
	//	예외가 없으면 정상 실행 후 종료
	//  예외가 있으면 이후 정상 실행 X, catch 구문으로 이동
	// } 
	// catch(예외를 처리할 객체) 
	// {
	// 예외 발생시 수행 할 코드 블럭	
	// }
	// catch( )
	// {
	// 	catch 구문은 여러 개 사용 가능
	// 	단, 발생한 예외와 일치하는 블럭만 수행
	// }
	// finally
	// {
	// 	예외 발생 여부와 관계없이 항상 실행되는 코드블럭
	// }

	public static void main(String[] args) 
	{
		try
		{
			int a = 5;
			int b = 0;
			int c = a/b;		   // 예외가 발생된 위치 (ExceptionMain.java:42)
				System.out.println(c); // 0으로 나누면 안돼! 라는 예외상황 호출
				
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{	
			System.out.println("catch문에 잡힌 5/0"); // 예외처리
		}
		catch(ArithmeticException e)
		{
			System.out.println("ArithmeticException 처리"); // 예외처리
		}
			System.out.println("END main()");
			
		try
		{// Date 클래스의 객체 now 선언;
		Date now;
		// now를 null로 초기화
		now = null;
			System.out.println(now.toLocaleString());
		}
		catch(Exception e)
		{
			System.out.println("Exception 클래스로 예외 처리");
			e.printStackTrace(); // 출력에 빨간줄 표시 그대로 출력 -> 지우면 출력되지 않음
			System.out.println("예외 메세지" + e.getMessage());
		}				
	}//END main()

}//END class
