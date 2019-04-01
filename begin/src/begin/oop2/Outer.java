package begin.oop2;

//문자열 변수 abst 를 멤버로 갖는 AbstractClass 작성
//내부에 매개변수와 반환값이 없는 추상메소드 abstMethod가 있음
abstract class AbstractClass {

	String abst = "abst";

	abstract void abstMethod();

}// End AbstractClass

//문자열 interf를 저장하고 있는 Interfacee 인터페이스 작성
// 내부에 매개변수와 반환값이 없는 추상메소드 interfMethod가 있음
interface Interfacee {

	String interf = "interf";

	void interMethod();

}// End Interfacee

public class Outer {
	// AbstractClass를 구현하는 익명의 이너클래스
	// - 참조 변수 사용
	AbstractClass abs = new AbstractClass() {
		@Override
		void abstMethod() {
			System.out.println("abst's value : " + abst);
		}
	};

	// Outer 클래스의 기본 생성자를 이용하여
	// Interfacee를 구현하는 익명의 중첩 클래스
	// - 참조 변수 사용 X
	Outer() {
		new Interfacee() {
			public void interMethod() {
				System.out.println("interf's value : " + interf);
			}
		}.interMethod();
	}

	class InstanceInner { // 인스턴스 이너 클래스
		String inst = "inst";
	}

	static class StaticInner { // 스태틱 중첩 클래스
		static String stat = "stat";

	}

	public void outerMethod() {
		class LocalInner { // 로컬 내부 클래스
			String local = "local";

			public void innerMethod() {
				System.out.println(local);
			}
		}// End LocalInner class
		new LocalInner().innerMethod();
	}

}// End Outer class
