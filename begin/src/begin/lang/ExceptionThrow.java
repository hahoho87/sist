package begin.lang;

public class ExceptionThrow {
	// throw를 사용하여 임의의 예외 던지기
	public static void main(String[] args) 
	{
		 try 
		 { 
			throw new Exception("예외 발생!!");
		 }
		 catch (Exception e)
		 {
			System.out.println("예외메세지 : " + e.getMessage());
		//	e.printStackTrace(); // 주석을 해제하면 예외가 발생하고, 출력을 새로고침 할때마다 예외의 위치가 바뀌어 출력되기도 함
		 }
		finally
		{
			System.out.println("finally 구문");
			System.out.println("예외 발생 여부 상관없이 실행됨");
		}
	 
	}//END main()

}//END class
