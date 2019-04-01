package begin.lang;

// Exception 클래스를 상속받는 UserException 클래스 작성
class UserException extends Exception
{	// 예외 메세지를 형식 매개변수(형식적인 매개변수 ex) String a, int b)로 받아 부모의 생성자에게 전달하는 생성자 작성
	UserException(String a)
	{
		super(a);
	}
}
public class ExceptionMake // 예외만들기 
{// 사용자 정의 예외 : Exception 상속 받아서 구현
	public static void main(String[] args) 
	{//사용자에게 정수 하나를 입력받아서 ->args[0] 
		int input = Integer.parseInt(args[0]);
		if(input < 0)
		{ 	// 0 미만이면 "양수가 아닙니다"를 메시지로
			try 
			{
				throw new UserException("양수가 아닙니다"); // 사용자정의 예외를 발생 시킴
			//	throw new NullPointerException();
			} 	
			catch (UserException e) // try에서 매개변수를 받고 임의로 예외를 발생시키는 역할 = catch
			{
				System.out.println(e.getMessage()); // 필요시 적절히 예외처리
				e.printStackTrace(); // /by zero 부분이 양수가 아닙니다 로 바뀜
			}
		}
		else
			System.out.println("양수입니다");
		
	}//END main

}//END class
