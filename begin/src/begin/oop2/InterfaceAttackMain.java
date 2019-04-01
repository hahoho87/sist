package begin.oop2;

//InterfaceAttack을 구현하는 InterfaceAttackImpl 클래스 작성

class InterfaceAttackImpl implements InterfaceAttack	{

	@Override
	public void attack() {
		System.out.println("implements를 이용 인터페이스 구현");
	}
	
}//End InterfaceAttackImpl

public class InterfaceAttackMain {

	public static void main(String[] args) {
		//InterfaceAttackImpl의 클래스 attack 메소드를 호출
		InterfaceAttackImpl iai = new InterfaceAttackImpl();
		iai.attack();
		
		//InterfaceAttackImpl의 클래스 attack 메소드를 호출
		//단, 참조 변수를 생성하지 않음
		new InterfaceAttackImpl().attack();		// 객체 생성은 하되, 참조는 하지 않음
		
		//InterfaceAttackImpl의 클래스 attack 메소드를 호출
		//익명의 객체 생성
		InterfaceAttack att = new InterfaceAttack() {
			@Override
			public void attack() {		
				System.out.println("익명 구현 객체를 이용 인터페이스 구현");
			}
		};						// 익명으로 클래스를 만들어서 한 번만 실행할 때 사용
		att.attack();
		
		//InterfaceAttackImpl의 클래스 attack 메소드를 호출
		//참조 변수를 생성하지 않고 익명으로 사용
		new InterfaceAttack() {
			@Override
			public void attack() {
				System.out.println("익명 구현 객체를 이용 인터페이스 구현2");
			}
		}.attack();					
		
		
	}//End main()

}//End InterfaceAttackMain
