package begin.oop;

public class ConstructorCarMain {

	public static void main(String[] args) {
		ConstructorCar c = new ConstructorCar();
		

//		System.out.println(c.toString());
		System.out.println(c); // 뒤에 .toString()을 굳이 붙여주지 않아도 적용해서 출력
		System.out.println();
		
		//색깔을 매개변수로 받는 생성자를 이용하여
		//ConstructorCar 클래스의 객체 red 생성
		ConstructorCar red = new ConstructorCar("Red");
		System.out.println(red);
		System.out.println();		//기본 생성자를 호출했기 때문에 이름, 문 개수가 채워짐
		
		//이름(범블비), 색(노란색), 문의 개수(2개)를
		//매개변수로 받는 생성자를 이용하여
		//ConstructorCar 클래스의 인스턴스 yellow 생성
		ConstructorCar yellow = new ConstructorCar("Bumblebell", "Yellow", 2);
		System.out.println(yellow);
		System.out.println();
		
		System.out.println("이름 : " + c.getName());
		System.out.println("색상 : " + c.getColor());
		System.out.println("문 개수 : " + c.getDoor());
		System.out.println("----------------");
		// ConstrutorCar(){ } 에서 초기화 해주었기 때문에
		// 초기값이 적용된 값 출력

		// 자동차의 이름은 myCar
		// 자동차의 색깔은 하얀색
		// 문은 4개를 갖는 ConstructorCar 클래스의 참조변수 c 생성

		c.setName("myCar");
		c.setColor("White");
		c.setdoor(4);

		System.out.println("이름 : " + c.getName());
		System.out.println("색상 : " + c.getColor());
		System.out.println("문 개수 : " + c.getDoor());

	}

}
