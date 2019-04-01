package begin.oop2;

//인터페이스
// 구현 클래스를 제어하기 위해 사용
//
//상수 및 추상 메소드만 정의
//	메소드의 구현부 { ... } 정의 불가
//	자식 or 구현 클래스에서 기능 오버라이딩
//	객체 생성 불가
//abstract, final, static 키워드 생략 가능
//자바의 단일 상속을 보완
//	한 클래스에서 다중 인터페이스 구현 가능
//	인터페이스 사이에 다중 상속 가능
//시스템 설계에 주로 사용

//인터페이스 선언 - interface 키워드 사용
//접근제한자 interface 인터페이스명 { ... }
//접근제한자 interface 인터페이스명 
//		  extends 부모 인터페이스명[, ...] {
//	상수;
//	추상메소드;
//}


public interface InterfaceA {
//	int i;	//선언만 하는건 불가능
	int i = 100;
	final int II = 200;
	final static int III = 300;
	
//	i = 5;	// final이 없어도 상수이기 때문에 값 변경 불가능
	
//	public void test()	{	}	// abstract 키워드가 없어도 추상메소드이기 때문에 body 설정 불가
	public void test();
	public abstract void testt();
	
}//End InterfaceA


interface InterfaceB	{
	final int CODE = 1234;
	public abstract void testB();
	
}//End InterfaceB


interface InterfaceC extends InterfaceA, InterfaceB	{
	int CODE_C = 5678;
	
}//End InterfaceC



