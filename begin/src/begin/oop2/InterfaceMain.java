package begin.oop2;

//InterfaceA를 구현하는 클래스
class InterfaceImpl implements InterfaceA	{

	@Override
	public void test() {
		System.out.println("i : "+ i);
//		i = 200;	//상수이기 때문에 값 변경 불가능
	}

	@Override
	public void testt() {
		System.out.println("II : " + InterfaceA.II);	// static이 없지만 static의 형식으로 가능
		System.out.println("III : " + III);				// static이 있지만 static 형식이 아니어도 가능
	}													// static이 기본이기 때문
	
}//End InterfaceImpl

//InterfaceC를 구현하는 InterfaceImpl2 클래스
class InterfaceImplTwo implements InterfaceC	{

	@Override
	public void test() {
	}

	@Override
	public void testt() {
	}

	@Override
	public void testB() {
		System.out.println("CODE : " + CODE);
		System.out.println("CODE_C : " + CODE_C);
	}
}//End InterfaceImplTwo


public class InterfaceMain {

	public static void main(String[] args) {
		//InterfaceImpl 클래스의 test, testt 메소드 호출
		InterfaceImpl impl = new InterfaceImpl();
		impl.test();
		impl.testt();
		
		//InterfaceImplTwo 클래스의 testB 메소드 호출
		InterfaceImplTwo implTwo = new InterfaceImplTwo();
		implTwo.testB();
		
	}

}
