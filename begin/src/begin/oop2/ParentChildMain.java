package begin.oop2;

public class ParentChildMain {

	public static void main(String[] args) {
		Parent par = new Child(); // 부모를 자식 타입으로 만듬 -> 다형성
//		Child chi = new Parent(); // 자식 -> 부모는 불가
//		Child chi = (Child) new Parent();
		par.printName();
		
		
		// Parent 클래스의 객체 p를 생성하고,
		// p의 이름을 "Ben"으로 설정
		System.out.println("---------------------------");
		Parent p = new Parent();	
			p.setName("Ben");

		// Child 클래스의 객체 c를 생성하고
		// c의 나이를 5로 설정
		// c의 이름을 ken으로 설정
			Child c = new Child();	
			c.setAge(5);
			c.setName("Ken");
		
		System.out.println("부모의 이름 : " + p.getName());
		System.out.println("자녀의 나이 : " + c.getAge());
		System.out.println("자녀의 이름 : " + c.getName());
	}

}
